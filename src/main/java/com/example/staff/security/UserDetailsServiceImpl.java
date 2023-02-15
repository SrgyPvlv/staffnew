package com.example.staff.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.staff.entity.Users;
import com.example.staff.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user= userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + username));
		
		UserDetails userDetails = User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().getName())
				.build();
		
		return userDetails;
	}

}
