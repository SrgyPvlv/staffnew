package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.CarModelEntity;

@Repository
public interface CarModelRepository extends JpaRepository<CarModelEntity,Long> {

}
