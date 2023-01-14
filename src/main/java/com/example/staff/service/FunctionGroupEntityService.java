package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.FunctionGroupEntity;

public interface FunctionGroupEntityService {

	FunctionGroupEntity getFunctionGroupEntityById(Long id);
	List<FunctionGroupEntity> getAllFunctionGroupEntity();
	FunctionGroupEntity addFunctionGroupEntity(FunctionGroupEntity functionGroupEntity);
	FunctionGroupEntity editFunctionGroupEntity(Long id,FunctionGroupEntity functionGroupEntity);
	void deleteFunctionGroupEntityById(Long id);
}
