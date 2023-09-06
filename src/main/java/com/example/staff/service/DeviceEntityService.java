package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.DeviceEntity;

public interface DeviceEntityService {

	DeviceEntity getDeviceEntityById(Long id);
	List<DeviceEntity> getAllDeviceEntity();
	DeviceEntity addDeviceEntity(DeviceEntity deviceEntity);
	DeviceEntity editDeviceEntity(Long id, DeviceEntity deviceEntity);
	void deleteDeviceEntityById(Long id);
	List<DeviceEntity> findDevicesByEmployeeId(Long id);
}
