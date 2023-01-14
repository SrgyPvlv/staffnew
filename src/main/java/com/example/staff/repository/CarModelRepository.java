package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staff.entity.CarModelEntity;

public interface CarModelRepository extends JpaRepository<CarModelEntity,Long> {

}
