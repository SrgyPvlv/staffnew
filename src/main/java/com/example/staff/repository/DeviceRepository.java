package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DeviceEntity;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

	List<DeviceEntity> findByEmployeeId(Long id);
}
