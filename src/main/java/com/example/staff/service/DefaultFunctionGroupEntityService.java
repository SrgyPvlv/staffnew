package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.staff.entity.FunctionGroupEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.FunctionGroupRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultFunctionGroupEntityService implements FunctionGroupEntityService {

private final FunctionGroupRepository functionGroupRepository;
	
	@Override
	public FunctionGroupEntity getFunctionGroupEntityById(@PathVariable Long id) {
		
		FunctionGroupEntity functionGroupEntity=functionGroupRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("FunctionGroupe not found: id = "+ id));
		return functionGroupEntity;
	}

	@Override
	public List<FunctionGroupEntity> getAllFunctionGroupEntity() {
		
		return functionGroupRepository.findAll();
	}

	@Override
	public FunctionGroupEntity addFunctionGroupEntity(FunctionGroupEntity functionGroupEntity) {
		
		return functionGroupRepository.saveAndFlush(functionGroupEntity);
	}

	@Override
	public FunctionGroupEntity editFunctionGroupEntity(@PathVariable Long id, @RequestBody FunctionGroupEntity functionGroupEntity) {
		FunctionGroupEntity editedFunctionGroupEntity=functionGroupRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("FunctionGroupe not found: id = "+ id));
		editedFunctionGroupEntity.setFunctionGroup(functionGroupEntity.getFunctionGroup());
		
		return functionGroupRepository.saveAndFlush(editedFunctionGroupEntity);
	}

	@Override
	public void deleteFunctionGroupEntityById(@PathVariable Long id) {
		functionGroupRepository.deleteById(id);
		
	}
}
