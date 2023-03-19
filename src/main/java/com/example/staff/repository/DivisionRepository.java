package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DivisionEntity;

@Repository
public interface DivisionRepository extends JpaRepository<DivisionEntity,Long>{

}
