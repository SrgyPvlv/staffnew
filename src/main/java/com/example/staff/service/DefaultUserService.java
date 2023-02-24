package com.example.staff.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.staff.entity.Users;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
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
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userDetailsPassword=userDetails.getPassword();
		if (user.getPassword().equals(userDetailsPassword)) {
			editedUser.setUsername(user.getUsername());
			editedUser.setPassword(user.getPassword());
			editedUser.setRole(user.getRole());
		} else {
		editedUser.setUsername(user.getUsername());
		editedUser.setPassword(encoder.encode(user.getPassword()));
		editedUser.setRole(user.getRole());}
		
		return userRepository.saveAndFlush(editedUser);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

}
