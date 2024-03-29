package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ReferenceEntity;

@Repository
public interface ReferenceRepository extends JpaRepository<ReferenceEntity, Long> {

}
