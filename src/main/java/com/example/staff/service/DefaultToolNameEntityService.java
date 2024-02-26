package com.example.staff.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.ToolNameEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.ToolNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultToolNameEntityService implements ToolNameEntityService {

	private final ToolNameRepository toolNameRepository;
	
	@Override
	public ToolNameEntity getToolNameEntityById(Long id) {
		ToolNameEntity toolName = toolNameRepository
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("ToolName not found: id = " + id));
		return toolName;
	}

	@Override
	public List<ToolNameEntity> getAllToolNameEntity() {
		
		return toolNameRepository.findAll(Sort.by(Sort.Direction.ASC,"toolName"));
	}

	@Override
	public ToolNameEntity addToolNameEntity(ToolNameEntity toolNameEntity) {
		
		return toolNameRepository.saveAndFlush(toolNameEntity);
	}

	@Override
	public ToolNameEntity editToolNameEntity(Long id, ToolNameEntity toolNameEntity) {
		ToolNameEntity editedToolName = toolNameRepository
				.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("ToolName not found: id = " + id));
		editedToolName.setToolName(toolNameEntity.getToolName());
		return editedToolName;
	}

	@Override
	public void deleteToolNameEntity(Long id) {
		
		toolNameRepository.deleteById(id);		
	}

}
