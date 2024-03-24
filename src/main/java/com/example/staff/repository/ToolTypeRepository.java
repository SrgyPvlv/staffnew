package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ToolTypeEntity;

@Repository
public interface ToolTypeRepository extends JpaRepository<ToolTypeEntity, Long> {

}
