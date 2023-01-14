package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.PositionEntity;

public interface PositionEntityService {

	PositionEntity getPositionEntityById(Long id);
	List<PositionEntity> getAllPositionEntity();
	PositionEntity addPositionEntity(PositionEntity positionEntity);
	PositionEntity editPositionEntity(Long id,PositionEntity positionEntity);
	void deletePositionEntityById(Long id);	
}
