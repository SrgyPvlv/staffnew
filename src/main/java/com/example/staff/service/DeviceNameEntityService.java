package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.DeviceNameEntity;

public interface DeviceNameEntityService {

	DeviceNameEntity getDeviceNameEntityById(Long id);
	List<DeviceNameEntity> getAllDeviceNameEntity();
	DeviceNameEntity addDeviceNameEntity(DeviceNameEntity deviceNameEntity);
	DeviceNameEntity editDeviceNameEntity(Long id, DeviceNameEntity deviceNameEntity);
	void deleteDeviceNameEntityById(Long id);
}
