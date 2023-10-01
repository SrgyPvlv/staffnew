package com.example.staff.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.CarEntity;
import com.example.staff.entity.DeviceEntity;
import com.example.staff.entity.EmployeeEntity;
import com.example.staff.entity.SertificateEntity;
import com.example.staff.helper.ExelHelper;
import com.example.staff.repository.CarRepository;
import com.example.staff.repository.DeviceRepository;
import com.example.staff.repository.EmployeeRepository;
import com.example.staff.repository.SertificateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultExelService implements ExelService {

	private final EmployeeRepository employeeRepository;
	private final CarRepository carRepository;
	private final SertificateRepository sertificateRepository;
	private final DeviceRepository deviceRepository;

	@Override
	public ByteArrayInputStream employeesLoad() {
		
		List<EmployeeEntity> employees = employeeRepository.findAll();
		ByteArrayInputStream in = ExelHelper.employeesToExcel(employees);
		
		return in;
	}

	@Override
	public ByteArrayInputStream carsLoad() {
		
		List<CarEntity> cars = carRepository.findAll();
		ByteArrayInputStream in = ExelHelper.carsToExcel(cars);
		
		return in;
	}

	@Override
	public ByteArrayInputStream sertificatesLoad() {
		
		List<SertificateEntity> sertificates = sertificateRepository.findAll();
		ByteArrayInputStream in = ExelHelper.sertificatesToExcel(sertificates);
		
		return in;
	}
	
	@Override
	public ByteArrayInputStream devicesLoad() {
		
		List<DeviceEntity> devices = deviceRepository.findAll();
		ByteArrayInputStream in = ExelHelper.devicesToExcel(devices);
		
		return in;
	}
		
}
