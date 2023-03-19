package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
