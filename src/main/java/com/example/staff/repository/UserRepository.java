package com.example.staff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staff.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String username);
	Boolean existsByUsername(String username);
}
