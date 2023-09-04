package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.DeviceNameEntity;
import com.example.staff.service.DeviceNameEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DeviceNameEntityController {
	
	private final DeviceNameEntityService deviceNameEntityService;

	@GetMapping("/devicenames/{id}")
	public ResponseEntity<DeviceNameEntity> getDeviceNameEntityById(@PathVariable Long id){
		
		try {
			return ResponseEntity.ok(deviceNameEntityService.getDeviceNameEntityById(id));
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/devicenames")
	public ResponseEntity<List<DeviceNameEntity>> getAllDeviceNameEntity() {
		try {
			return ResponseEntity.ok(deviceNameEntityService.getAllDeviceNameEntity());
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/devicenames")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceNameEntity> addDeviceNameEntity(@RequestBody DeviceNameEntity deviceName) {
		try {
			return new ResponseEntity<>(deviceNameEntityService.addDeviceNameEntity(deviceName),HttpStatus.CREATED);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/devicenames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceNameEntity> editDeviceNameEntity(@PathVariable Long id,@RequestBody DeviceNameEntity deviceName) {
		try {
			return new ResponseEntity<>(deviceNameEntityService.editDeviceNameEntity(id, deviceName),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/devicenames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteDeviceNameEntityById(@PathVariable Long id) {
		
		try {
			deviceNameEntityService.deleteDeviceNameEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
