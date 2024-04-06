package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.CarEntity;

public interface CarEntityService {

	CarEntity getCarEntityById(Long id);
	List<CarEntity> getAllCarEntity();
	CarEntity addCarEntity(CarEntity carEntity);
	CarEntity editCarEntity(Long id, CarEntity carEntity);
	void deleteCarEntityById(Long id);
	List<CarEntity> findByNumberModelEmployee(String filter1, String filter2, String filter3);
}
