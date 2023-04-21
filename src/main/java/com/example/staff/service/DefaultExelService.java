package com.example.staff.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.helper.ExelHelper;
import com.example.staff.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultExelService implements ExelService {

	private final EmployeeRepository employeeRepository;

	@Override
	public ByteArrayInputStream load() {
		
		List<EmployeeEntity> employees = employeeRepository.findAll();
		ByteArrayInputStream in = ExelHelper.employeesToExcel(employees);
		
		return in;
	}
	
	
}
