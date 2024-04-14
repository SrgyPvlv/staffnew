package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DeviceEntity;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

	List<DeviceEntity> findByDeviceNumberIgnoreCaseContainingOrDeviceTypeDeviceTypeNameIgnoreCaseContainingOrDeviceNameDeviceNameIgnoreCaseContainingOrEmployeeNameIgnoreCaseContainingOrDeviceCommentIgnoreCaseContainingOrStorePlaceIgnoreCaseContainingOrderByDeviceTypeDeviceTypeName(String filter1, String filter2, String filter3, String filter4, String filter5, String filter6);
	List<DeviceEntity> findByEmployeeIdOrderByDeviceTypeDeviceTypeName(Long id);
}