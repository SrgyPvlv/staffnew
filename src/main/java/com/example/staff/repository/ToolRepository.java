package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ToolEntity;

@Repository
public interface ToolRepository extends JpaRepository<ToolEntity, Long> {

	List<ToolEntity> findByToolNumberIgnoreCaseContainingOrToolTypeToolTypeNameIgnoreCaseContainingOrToolNameToolNameIgnoreCaseContainingOrEmployeeNameIgnoreCaseContainingOrToolCommentIgnoreCaseContainingOrStorePlaceIgnoreCaseContainingOrderByToolType(String filter1, String filter2, String filter3, String filter4, String filter5, String filter6);
	List<ToolEntity> findByEmployeeId(Long id);
}
