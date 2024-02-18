package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.CarParkingEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.CarParkingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCarParkingEntityService implements CarParkingEntityService {

	private final CarParkingRepository carParkingRepository;
	
	@Override
	public CarParkingEntity getCarParkingEntityById(Long id) {
		CarParkingEntity carParkingEntity=carParkingRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("CarParking not found: id = " + id));
		return carParkingEntity;
	}

	@Override
	public List<CarParkingEntity> getAllCarParkingEntity() {
		List<CarParkingEntity> carparkings=carParkingRepository.findAll();
		return carparkings;
	}

	@Override
	public CarParkingEntity addCarParkingEntity(CarParkingEntity carParkingEntity) {
		
		return carParkingRepository.saveAndFlush(carParkingEntity);
	}

	@Override
	public CarParkingEntity editCarParkingEntity(Long id, CarParkingEntity carParkingEntity) {
		CarParkingEntity editedCarParkingEntity=carParkingRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("CarModel not found: id = " + id));
		editedCarParkingEntity.setParkingName(carParkingEntity.getParkingName());
		return carParkingRepository.saveAndFlush(editedCarParkingEntity);
	}

	@Override
	public void deleteCarParkingEntityById(Long id) {
		carParkingRepository.deleteById(id);
	}
}
