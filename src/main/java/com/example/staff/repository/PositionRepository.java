package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staff.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity,Long> {

}
