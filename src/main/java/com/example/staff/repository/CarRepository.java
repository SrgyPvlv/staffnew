package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
	
	List<CarEntity> findByCarNumberIgnoreCaseContainingOrCarModelCarModelIgnoreCaseContainingOrEmployeeNameIgnoreCaseContainingOrderByCarNumber(String filter1, String filter2, String filter3);
}
