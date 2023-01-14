package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.staff.entity.DivisionEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.DivisionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultDivisionEntityService implements DivisionEntityService {
	
	
private final DivisionRepository divisionRepository;
	
	@Override
	public DivisionEntity getDivisionEntityById(@PathVariable Long id) {
		
		DivisionEntity departmentEntity=divisionRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Division not found: id = "+ id));
		return departmentEntity;
	}

	@Override
	public List<DivisionEntity> getAllDivisionEntity() {
		
		return divisionRepository.findAll();
	}

	@Override
	public DivisionEntity addDivisionEntity(DivisionEntity divisionEntity) {
		
		return divisionRepository.saveAndFlush(divisionEntity);
	}

	@Override
	public DivisionEntity editDivisionEntity(@PathVariable Long id, @RequestBody DivisionEntity divisionEntity) {
		DivisionEntity editedDivisionEntity=divisionRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Division not found: id = "+ id));
		editedDivisionEntity.setDivision(divisionEntity.getDivision());
		
		return divisionRepository.saveAndFlush(editedDivisionEntity);
	}

	@Override
	public void deleteDivisionEntityById(@PathVariable Long id) {
		divisionRepository.deleteById(id);
		
	}

}
