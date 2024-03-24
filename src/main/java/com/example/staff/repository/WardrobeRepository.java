package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.WardrobeEntity;

@Repository
public interface WardrobeRepository extends JpaRepository<WardrobeEntity, Long> {
	
	List<WardrobeEntity> findByNumberEqualsOrEmployeeNameIgnoreCaseContainingOrRoomIgnoreCaseContainingOrderByNumberAsc(int filter1,String filter2,String filter3);
	List<WardrobeEntity> findByEmployeeId(Long id);
}
