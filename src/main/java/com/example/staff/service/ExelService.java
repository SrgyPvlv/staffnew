package com.example.staff.service;

import java.io.ByteArrayInputStream;

public interface ExelService {
	
	ByteArrayInputStream employeesLoad();
	ByteArrayInputStream carsLoad();
	ByteArrayInputStream sertificatesLoad();
	ByteArrayInputStream devicesLoad();
	ByteArrayInputStream toolsLoad();

}
