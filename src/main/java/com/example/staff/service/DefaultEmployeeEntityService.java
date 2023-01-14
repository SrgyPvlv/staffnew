package com.example.staff.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultEmployeeEntityService implements EmployeeEntityService {
	private final EmployeeRepository employeeRepository;
	@Override
	public EmployeeEntity getEmployeeEntityById(Long id) {	
		EmployeeEntity employee=employeeRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Employee not found: id = " + id));
		return employee;
	}

	@Override
	public List<EmployeeEntity> getAllEmployeeEntity() {
		List<EmployeeEntity> employees=employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		return employees;
	}

	@Override
	public EmployeeEntity addEmployeeEntity(EmployeeEntity employeeEntity) {
		return employeeRepository.saveAndFlush(employeeEntity);
		
	}

	@Override
	public EmployeeEntity editEmployeeEntity(Long id, EmployeeEntity employeeEntity) {
		EmployeeEntity editedEmployeeEntity=employeeRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Employee not found: id = " + id));
		editedEmployeeEntity.setName(employeeEntity.getName());
		editedEmployeeEntity.setMobilePhone(employeeEntity.getMobilePhone());
		editedEmployeeEntity.setBirthday(employeeEntity.getBirthday());
		editedEmployeeEntity.setLocalPhone(employeeEntity.getLocalPhone());
		editedEmployeeEntity.setEmployeeComment(employeeEntity.getEmployeeComment());
		editedEmployeeEntity.setLogin(employeeEntity.getLogin());
		editedEmployeeEntity.setEmail(employeeEntity.getEmail());
		editedEmployeeEntity.setEmployeeComment(employeeEntity.getEmployeeComment());
		editedEmployeeEntity.setFactDepartment(employeeEntity.getFactDepartment());
		editedEmployeeEntity.setFactDepartment(employeeEntity.getFactDepartment());
		editedEmployeeEntity.setCar(employeeEntity.getCar());
		editedEmployeeEntity.setPosition(employeeEntity.getPosition());
		
		return employeeRepository.saveAndFlush(editedEmployeeEntity);
	}

	@Override
	public void deleteEmployEntityById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<EmployeeEntity> findByNameMobilePositionContaining(String filter) {
				
		List<EmployeeEntity> byName=employeeRepository.findByNameIgnoreCaseContainingOrderByNameAsc(filter);
		List<EmployeeEntity> byMobile=employeeRepository.findByMobilePhoneContainingOrderByNameAsc(filter);
		List<EmployeeEntity> byPosition=employeeRepository.findByPositionPositionIgnoreCaseContainingOrderByNameAsc(filter);
		List<EmployeeEntity> byNameMobilePosition=new ArrayList<>();
		Stream.of(byName,byMobile,byPosition).forEach(byNameMobilePosition::addAll);
		
		return byNameMobilePosition;
	}

	@Override
	public List<EmployeeEntity> findByFactDivisionOrGroupeOrFunctionGroupOrderByNameAsc(String filter1,String filter2,String filter3) {
		 
		return employeeRepository.findByFactDepartmentDivisionDivisionOrFactDepartmentGroupeGroupeOrFactDepartmentFunctionGroupFunctionGroupOrderByNameAsc(filter1,filter2,filter3);
	}

	@Override
	public List<EmployeeEntity> findByStaffDivisionOrGroupeOrFunctionGroupOrderByNameAsc(String filter1,String filter2,String filter3) {
		
		return employeeRepository.findByStaffDepartmentDivisionDivisionOrStaffDepartmentGroupeGroupeOrStaffDepartmentFunctionGroupFunctionGroupOrderByNameAsc(filter1,filter2,filter3);
	}

}
