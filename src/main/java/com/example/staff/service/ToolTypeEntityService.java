package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ToolTypeEntity;

public interface ToolTypeEntityService {

	ToolTypeEntity getToolTypeEntityById(Long id);
	List<ToolTypeEntity> getAllToolTypeEntity();
	ToolTypeEntity addToolTypeEntity(ToolTypeEntity toolTypeEntity);
	ToolTypeEntity editToolTypeEntity(Long id, ToolTypeEntity toolTypeEntity);
	void deleteToolTypeEntity(Long id);
}
