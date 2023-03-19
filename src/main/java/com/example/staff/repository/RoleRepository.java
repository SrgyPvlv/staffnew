package com.example.staff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {

	Optional<Roles> findByName(String name);
}
