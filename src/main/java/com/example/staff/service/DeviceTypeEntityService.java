package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.DeviceTypeEntity;

public interface DeviceTypeEntityService {

	DeviceTypeEntity getDeviceTypeEntityById(Long id);
	List<DeviceTypeEntity> getAllDeviceTypeEntity();
	DeviceTypeEntity addDeviceTypeEntity(DeviceTypeEntity deviceTypeEntity);
	DeviceTypeEntity editDeviceTypeEntity(Long id, DeviceTypeEntity deviceTypeEntity);
	void deleteDeviceTypeEntityById(Long id);
}
