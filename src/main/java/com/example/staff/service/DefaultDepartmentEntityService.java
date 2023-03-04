package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.staff.entity.DepartmentEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultDepartmentEntityService implements DepartmentEntityService{
	
	private final DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentEntity getDepartmentEntityById(@PathVariable Long id) {
		
		DepartmentEntity departmentEntity=departmentRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Department not found: id = "+ id));
		return departmentEntity;
	}

	@Override
	public List<DepartmentEntity> getAllDepartmentEntity() {
		
		return departmentRepository.findAll();
	}

	@Override
	public DepartmentEntity addDepartmentEntity(DepartmentEntity departmentEntity) {
		
		return departmentRepository.saveAndFlush(departmentEntity);
	}

	@Override
	public DepartmentEntity editDepartmentEntity(@PathVariable Long id, @RequestBody DepartmentEntity departmentEntity) {
		DepartmentEntity editedDepartmentEntity=departmentRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Department not found: id = "+ id));
		editedDepartmentEntity.setDivision(departmentEntity.getDivision());
		editedDepartmentEntity.setGroupe(departmentEntity.getGroupe());
		editedDepartmentEntity.setFunctionGroup(departmentEntity.getFunctionGroup());
		
		return departmentRepository.saveAndFlush(editedDepartmentEntity);
	}

	@Override
	public void deleteDepartmentEntityById(@PathVariable Long id) {
		departmentRepository.deleteById(id);
		
	}

}
