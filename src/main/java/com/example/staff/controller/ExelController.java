package com.example.staff.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.service.ExelService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ExelController {
	private final ExelService exelService;
	
	@GetMapping("/exel/download/employees")
	public ResponseEntity<Resource> getEmployeesFile(){
		String filename = "employees.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.employeesLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
	@GetMapping("/exel/download/cars")
	public ResponseEntity<Resource> getCarsFile(){
		String filename = "cars.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.carsLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
	@GetMapping("/exel/download/sertificates")
	public ResponseEntity<Resource> getSertificatesFile(){
		String filename = "sertificates.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.sertificatesLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
	@GetMapping("/exel/download/devices")
	public ResponseEntity<Resource> getDevicesFile(){
		String filename = "devices.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.devicesLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
	@GetMapping("/exel/download/tools")
	public ResponseEntity<Resource> getToolsFile(){
		String filename = "tools.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.toolsLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}
	
	@GetMapping("/exel/download/wardrobes")
	public ResponseEntity<Resource> getWardrobesFile(){
		String filename = "wardrobes.xlsx";
		InputStreamResource file = new InputStreamResource(exelService.wardrobesLoad());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
	}

}
