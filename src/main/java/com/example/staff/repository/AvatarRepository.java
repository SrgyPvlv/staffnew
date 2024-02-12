package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.AvatarEntity;

@Repository
public interface AvatarRepository extends JpaRepository<AvatarEntity, Long> {

	AvatarEntity findByEmployeeId(Long id);
}
