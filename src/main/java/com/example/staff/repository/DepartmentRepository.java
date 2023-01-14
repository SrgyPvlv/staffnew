package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staff.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
