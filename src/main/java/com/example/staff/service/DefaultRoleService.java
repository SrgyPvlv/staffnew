package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.Roles;
import com.example.staff.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService{
	private final RoleRepository roleRepository;

	@Override
	public List<Roles> getAllRoles() {
	
		return roleRepository.findAll();
	}

}
