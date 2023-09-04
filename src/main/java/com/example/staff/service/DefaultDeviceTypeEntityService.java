package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.DeviceTypeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.DeviceTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultDeviceTypeEntityService implements DeviceTypeEntityService{
	
	private final DeviceTypeRepository deviceTypeRepository;

	@Override
	public DeviceTypeEntity getDeviceTypeEntityById(Long id) {
		
		DeviceTypeEntity deviceType=deviceTypeRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("DeviceType not found: id = " +id));
		return deviceType;
	}

	@Override
	public List<DeviceTypeEntity> getAllDeviceTypeEntity() {
		
		return deviceTypeRepository.findAll();
	}

	@Override
	public DeviceTypeEntity addDeviceTypeEntity(DeviceTypeEntity deviceType) {
		
		return deviceTypeRepository.saveAndFlush(deviceType);
	}

	@Override
	public DeviceTypeEntity editDeviceTypeEntity(Long id, DeviceTypeEntity deviceType) {
		
		DeviceTypeEntity editedDeviceType = deviceTypeRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("DeviceType not found: id = "+id));
		editedDeviceType.setDeviceTypeName(deviceType.getDeviceTypeName());
		
		return deviceTypeRepository.saveAndFlush(editedDeviceType);
	}

	@Override
	public void deleteDeviceTypeEntityById(Long id) {
		
		deviceTypeRepository.deleteById(id);	
	}

}
