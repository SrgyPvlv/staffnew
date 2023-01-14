package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.DivisionEntity;

public interface DivisionEntityService {

	DivisionEntity getDivisionEntityById(Long id);
	List<DivisionEntity> getAllDivisionEntity();
	DivisionEntity addDivisionEntity(DivisionEntity divisionEntity);
	DivisionEntity editDivisionEntity(Long id,DivisionEntity divisionEntity);
	void deleteDivisionEntityById(Long id);
}
