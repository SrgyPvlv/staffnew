package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ToolEntity;

public interface ToolEntityService {

	ToolEntity getToolEntityById(Long id);
	List<ToolEntity> getAllToolEntity();
	ToolEntity addToolEntity(ToolEntity toolEntity);
	ToolEntity editToolEntity(Long id, ToolEntity toolEntity);
	void deleteToolEntity(Long id);
	List<ToolEntity> findByNumberTypeNameEmployeeCommentPlace(String filter1, String filter2, String filter3, String filter4, String filter5, String filter6);
	List<ToolEntity> findToolsByEmployeeId(Long id);
}
