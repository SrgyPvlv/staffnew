package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.ToolEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.ToolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultToolEntityService implements ToolEntityService {

	private final ToolRepository toolRepository;
	
	@Override
	public ToolEntity getToolEntityById(Long id) {
		ToolEntity toolEntity = toolRepository
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Tool not found: id = " + id));
		return toolEntity;
	}

	@Override
	public List<ToolEntity> getAllToolEntity() {
		
		return toolRepository.findAll();
	}

	@Override
	public ToolEntity addToolEntity(ToolEntity toolEntity) {
		
		return toolRepository.saveAndFlush(toolEntity);
	}

	@Override
	public ToolEntity editToolEntity(Long id, ToolEntity toolEntity) {
		
		ToolEntity editedTool = toolRepository
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Tool not found: id = " + id));
		editedTool.setToolType(toolEntity.getToolType());
		editedTool.setToolName(toolEntity.getToolName());
		editedTool.setToolNumber(toolEntity.getToolNumber());
		editedTool.setEmployee(toolEntity.getEmployee());
		editedTool.setToolComment(toolEntity.getToolComment());
		editedTool.setToolAccounting(toolEntity.getToolAccounting());
		editedTool.setStorePlace(toolEntity.getStorePlace());
		return toolRepository.saveAndFlush(editedTool);
	}

	@Override
	public void deleteToolEntity(Long id) {
		
		toolRepository.deleteById(id);

	}

	@Override
	public List<ToolEntity> findByNumberTypeNameEmployeeCommentPlace(String filter1, String filter2, String filter3,
			String filter4, String filter5, String filter6) {
		
		return toolRepository.findByToolNumberIgnoreCaseContainingOrToolTypeToolTypeNameIgnoreCaseContainingOrToolNameToolNameIgnoreCaseContainingOrEmployeeNameIgnoreCaseContainingOrToolCommentIgnoreCaseContainingOrStorePlaceIgnoreCaseContainingOrderByToolType(filter1, filter2, filter3, filter4, filter5, filter6);
	}

	@Override
	public List<ToolEntity> findToolsByEmployeeId(Long id) {
		
		return toolRepository.findByEmployeeId(id);
	}

}
