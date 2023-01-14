package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staff.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity,Long> {

	List<CarEntity> findByCarNumberIgnoreCaseContainingOrderByCarNumber(String filter);
	
	List<CarEntity> findByCarModelCarModelIgnoreCaseContainingOrderByCarNumber(String filter);
}
