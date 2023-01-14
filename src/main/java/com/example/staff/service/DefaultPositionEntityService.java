package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.PositionEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.PositionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultPositionEntityService implements PositionEntityService{
	private final PositionRepository positionRepository;
	
	@Override
	public PositionEntity getPositionEntityById(Long id) {
		PositionEntity positionEntity=positionRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Position not found: id = "+id));
		return positionEntity;
	}

	@Override
	public List<PositionEntity> getAllPositionEntity() {
		List<PositionEntity> positions=positionRepository.findAll();
		
		return positions;
	}

	@Override
	public PositionEntity addPositionEntity(PositionEntity positionEntity) {
		return positionRepository.saveAndFlush(positionEntity);	
	}

	@Override
	public PositionEntity editPositionEntity(Long id, PositionEntity positionEntity) {
		PositionEntity editedPositionEntity=positionRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Position not found: id = "+id));
		editedPositionEntity.setPosition(positionEntity.getPosition());
		
		return positionRepository.saveAndFlush(editedPositionEntity);	
	}

	@Override
	public void deletePositionEntityById(Long id) {
		positionRepository.deleteById(id);
		
	}
}
