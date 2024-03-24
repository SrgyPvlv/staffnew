package com.example.staff.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.RefreshToken;
import com.example.staff.entity.Roles;
import com.example.staff.entity.Users;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.exception.TokenRefreshException;
import com.example.staff.payload.JwtResponse;
import com.example.staff.payload.LoginRequest;
import com.example.staff.payload.MessageResponse;
import com.example.staff.payload.SignupRequest;
import com.example.staff.payload.TokenRefreshRequest;
import com.example.staff.payload.TokenRefreshResponse;
import com.example.staff.repository.RoleRepository;
import com.example.staff.repository.UserRepository;
import com.example.staff.security.JwtUtils;
import com.example.staff.security.RefreshTokenService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final RoleRepository roleRepository;
	private final RefreshTokenService refreshTokenService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userDetailsName=userDetails.getUsername();
		Long userDetailsId=userRepository.findByUsername(userDetailsName).orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + userDetailsName)).getId();
		String jwt = jwtUtils.generateJwtToken(userDetails);
		
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetailsId);

		return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getUsername(), roles));
	}
	
	@PostMapping("/refreshtoken")
	  public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
	    String requestRefreshToken = request.getRefreshToken();
	    
	    try {
	    RefreshToken rt=refreshTokenService.findByToken(requestRefreshToken)
	    		.orElseThrow(() -> new ItemNotFoundException("RefreshToken not found"));
	    RefreshToken rt1=refreshTokenService.verifyExpiration(rt);
	    Users user=rt1.getUser();
	    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
	    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));}
	    catch(Exception ex) {return new ResponseEntity<>(new TokenRefreshException(requestRefreshToken,
	            "Refresh token is not in database!"),HttpStatus.GONE);}
	  }
	
	@PostMapping("/signup")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		Roles adminRole = roleRepository.findByName("ADMIN")
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		Users user = new Users(null,signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()),adminRole);

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
		try {
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userDetailsName=userDetails.getUsername();
		Long userDetailsId=userRepository.findByUsername(userDetailsName).orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + userDetailsName)).getId();
		
		refreshTokenService.deleteByUserId(userDetailsId);
	    return ResponseEntity.ok(new MessageResponse("Log out successful!"));} catch (Exception ex) {return ResponseEntity.badRequest().body(new MessageResponse("RefreshToken has been deleted allready!"));}
	  }
}
