package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.CarParkingEntity;

@Repository
public interface CarParkingRepository extends JpaRepository<CarParkingEntity,Long>{

}
