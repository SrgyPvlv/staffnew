package com.example.staff.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.staff.entity.Users;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.UserRepository;
import com.example.staff.security.RefreshTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final RefreshTokenService refreshTokenService;
	
	@Override
	public Users getUsersById(Long id) {
		Users user=userRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("User not found: id = "+id));
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users=userRepository.findAll();
		return users;
	}

	@Override
	public Users editUser(Long id, Users user) {
		Users editedUser=userRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("User not found: id = "+id));
		
		if (editedUser.getPassword().equals(user.getPassword())) {
			editedUser.setUsername(user.getUsername());
			editedUser.setRole(user.getRole());
		} else {
		editedUser.setUsername(user.getUsername());
		editedUser.setPassword(encoder.encode(user.getPassword()));
		editedUser.setRole(user.getRole());}
		
		return userRepository.saveAndFlush(editedUser);
	}

	@Override
	public void deleteUserById(Long id) {
		try {
		refreshTokenService.deleteByUserId(id);
		userRepository.deleteById(id);}catch(Exception ex) {System.out.println("RefreshToken not found");};
		
	}

}
