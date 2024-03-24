package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.CarParkingEntity;

public interface CarParkingEntityService {

	CarParkingEntity getCarParkingEntityById(Long id);
	List<CarParkingEntity> getAllCarParkingEntity();
	CarParkingEntity addCarParkingEntity(CarParkingEntity carParkingEntity);
	CarParkingEntity editCarParkingEntity(Long id, CarParkingEntity carParkingEntity);
	void deleteCarParkingEntityById(Long id);
}
