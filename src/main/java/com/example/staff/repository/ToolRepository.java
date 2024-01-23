package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ToolEntity;

@Repository
public interface ToolRepository extends JpaRepository<ToolEntity, Long> {

}
