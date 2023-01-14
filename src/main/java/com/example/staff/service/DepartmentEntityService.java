package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.DepartmentEntity;

public interface DepartmentEntityService {

	DepartmentEntity getDepartmentEntityById(Long id);
	List<DepartmentEntity> getAllDepartmentEntity();
	DepartmentEntity addDepartmentEntity(DepartmentEntity positionEntity);
	DepartmentEntity editDepartmentEntity(Long id,DepartmentEntity positionEntity);
	void deleteDepartmentEntityById(Long id);
}
