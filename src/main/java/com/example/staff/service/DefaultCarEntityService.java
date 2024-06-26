package com.example.staff.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.CarEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCarEntityService implements CarEntityService {
	
	private final CarRepository carRepository;
	
	@Override
	public CarEntity getCarEntityById(Long id) {
		CarEntity carEntity=carRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Car not found: id = " + id));
		return carEntity;
	}

	@Override
	public List<CarEntity> getAllCarEntity() {
		List<CarEntity> cars=carRepository.findAll(Sort.by(Sort.Direction.ASC,"carNumber"));
		return cars;
	}

	@Override
	public CarEntity addCarEntity(CarEntity carEntity) {
		return carRepository.saveAndFlush(carEntity);
		
	}

	@Override
	public CarEntity editCarEntity(Long id, CarEntity carEntity) {
		CarEntity editedCarEntity=carRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Car not found: id = " + id));
		editedCarEntity.setCarNumber(carEntity.getCarNumber());
		editedCarEntity.setCarComment(carEntity.getCarComment());
		editedCarEntity.setCarModel(carEntity.getCarModel());
		editedCarEntity.setCarParking(carEntity.getCarParking());
		
		return carRepository.saveAndFlush(editedCarEntity);
	}

	@Override
	public void deleteCarEntityById(Long id) {
		carRepository.deleteById(id);
		
	}

	@Override
	public List<CarEntity> findByNumberModelEmployee(String filter1, String filter2, String filter3) {
		
		return carRepository.findByCarNumberIgnoreCaseContainingOrCarModelCarModelIgnoreCaseContainingOrEmployeeNameIgnoreCaseContainingOrderByCarNumber(filter1, filter2, filter3);
	}

	
}
