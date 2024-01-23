package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ToolNameEntity;

public interface ToolNameEntityService {

	ToolNameEntity getToolNameEntityById(Long id);
	List<ToolNameEntity> getAllToolNameEntity();
	ToolNameEntity addToolNameEntity(ToolNameEntity toolNameEntity);
	ToolNameEntity editToolNameEntity(Long id, ToolNameEntity toolNameEntity);
	void deleteToolNameEntity(Long id);
}
