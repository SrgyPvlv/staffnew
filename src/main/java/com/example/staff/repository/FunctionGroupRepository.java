package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.FunctionGroupEntity;

@Repository
public interface FunctionGroupRepository extends JpaRepository<FunctionGroupEntity,Long> {

}
