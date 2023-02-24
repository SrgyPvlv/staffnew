package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.Users;

public interface UserService {

	Users getUsersById(Long id);
	List<Users> getAllUsers();
	Users editUser(Long id,Users user);
	void deleteUserById(Long id);
}
