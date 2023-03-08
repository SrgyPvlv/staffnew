package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.Users;
import com.example.staff.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

private final UserService userService;
	
	@GetMapping("/users/{id}")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public ResponseEntity<Users> getUserById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(userService.getUsersById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public ResponseEntity<List<Users>> getAllUsers(){
		try {
			return ResponseEntity.ok(userService.getAllUsers());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
		
	@PutMapping("/users/{id}")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public ResponseEntity<Users> editUser(@PathVariable Long id,@RequestBody Users user){
		try {
			return new ResponseEntity<>(userService.editUser(id, user),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id){
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
