package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.DeviceEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.DeviceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultDeviceEntityService implements DeviceEntityService {

	private final DeviceRepository deviceRepository;
	
	@Override
	public DeviceEntity getDeviceEntityById(Long id) {
		
		DeviceEntity device = deviceRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Device not found: id = "+id));
		return device;
	}

	@Override
	public List<DeviceEntity> getAllDeviceEntity() {
		
		return deviceRepository.findAll();
	}

	@Override
	public DeviceEntity addDeviceEntity(DeviceEntity device) {
		
		return deviceRepository.saveAndFlush(device);
	}

	@Override
	public DeviceEntity editDeviceEntity(Long id, DeviceEntity device) {
		
		DeviceEntity editedDevice = deviceRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Device not found: id = "+ id));
		editedDevice.setDeviceType(device.getDeviceType());
		editedDevice.setDeviceName(device.getDeviceName());
		editedDevice.setDeviceNumber(device.getDeviceNumber());
		editedDevice.setEmployee(device.getEmployee());
		editedDevice.setDeviceComment(device.getDeviceComment());
		editedDevice.setDeviceAccounting(device.getDeviceAccounting());
		editedDevice.setStorePlace(device.getStorePlace());
		editedDevice.setVerificationNeed(device.isVerificationNeed());
		editedDevice.setInVerification(device.isInVerification());
		
		return deviceRepository.saveAndFlush(editedDevice);
	}

	@Override
	public void deleteDeviceEntityById(Long id) {
		
		deviceRepository.deleteById(id);	
	}

	@Override
	public List<DeviceEntity> findDevicesByEmployeeId(Long id) {
		
		return deviceRepository.findByEmployeeId(id);
	}

}
