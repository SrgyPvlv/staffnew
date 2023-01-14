package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.CarModelEntity;

public interface CarModelEntityService {

	CarModelEntity getCarModelEntityById(Long id);
	List<CarModelEntity> getAllCarModelEntity();
	CarModelEntity addCarModelEntity(CarModelEntity carModelEntity);
	CarModelEntity editCarModelEntity(Long id, CarModelEntity carModelEntity);
	void deleteCarModelEntityById(Long id);
}
