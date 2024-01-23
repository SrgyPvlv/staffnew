package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ToolEntity;

public interface ToolEntityService {

	ToolEntity getToolEntityById(Long id);
	List<ToolEntity> getAllToolEntity();
	ToolEntity addToolEntity(ToolEntity toolEntity);
	ToolEntity editToolEntity(Long id, ToolEntity toolEntity);
	void deleteToolEntity(Long id);
}
