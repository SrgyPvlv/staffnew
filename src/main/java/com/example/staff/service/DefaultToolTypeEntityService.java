package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.ToolTypeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.ToolTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultToolTypeEntityService implements ToolTypeEntityService {

	private final ToolTypeRepository toolTypeRepository;
	
	@Override
	public ToolTypeEntity getToolTypeEntityById(Long id) {
		ToolTypeEntity toolType = toolTypeRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("ToolType not found: id = " +id));
		return toolType;
	}

	@Override
	public List<ToolTypeEntity> getAllToolTypeEntity() {
		
		return toolTypeRepository.findAll();
	}

	@Override
	public ToolTypeEntity addToolTypeEntity(ToolTypeEntity toolTypeEntity) {
		
		return toolTypeRepository.saveAndFlush(toolTypeEntity);
	}

	@Override
	public ToolTypeEntity editToolTypeEntity(Long id, ToolTypeEntity toolTypeEntity) {
		ToolTypeEntity editedToolType = toolTypeRepository
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("ToolType not found: id = " +id));
		editedToolType.setToolTypeName(toolTypeEntity.getToolTypeName());
		
		return toolTypeRepository.saveAndFlush(editedToolType);
	}

	@Override
	public void deleteToolTypeEntity(Long id) {
		
		toolTypeRepository.deleteById(id);
	}

}
