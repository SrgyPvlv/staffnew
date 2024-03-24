package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ToolNameEntity;

@Repository
public interface ToolNameRepository extends JpaRepository<ToolNameEntity,Long> {

}
