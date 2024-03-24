package com.example.staff.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.DeviceNameEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.DeviceNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultDeviceNameEntityService implements DeviceNameEntityService {
	
	private final DeviceNameRepository deviceNameRepository;

	@Override
	public DeviceNameEntity getDeviceNameEntityById(Long id) {
		
		DeviceNameEntity deviceName = deviceNameRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("DeviceName not found id: "+id));
		return deviceName;
	}

	@Override
	public List<DeviceNameEntity> getAllDeviceNameEntity() {
		
		return deviceNameRepository.findAll(Sort.by(Sort.Direction.ASC,"deviceName"));
	}

	@Override
	public DeviceNameEntity addDeviceNameEntity(DeviceNameEntity deviceName) {
		
		return deviceNameRepository.saveAndFlush(deviceName);
	}

	@Override
	public DeviceNameEntity editDeviceNameEntity(Long id, DeviceNameEntity deviceName) {
		
		DeviceNameEntity editedDeviceName = deviceNameRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("DeviceName not found: id= "+id));
		editedDeviceName.setDeviceName(deviceName.getDeviceName());
		
		return deviceNameRepository.saveAndFlush(editedDeviceName);
	}

	@Override
	public void deleteDeviceNameEntityById(Long id) {
		
		deviceNameRepository.deleteById(id);		
	}

}
