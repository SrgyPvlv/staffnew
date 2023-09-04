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

import com.example.staff.entity.DeviceTypeEntity;
import com.example.staff.service.DeviceTypeEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DeviceTypeEntityController {

	private final DeviceTypeEntityService deviceTypeEntityService;
	
	@GetMapping("/devicetypes/{id}")
	public ResponseEntity<DeviceTypeEntity> getDeviceTypeEntityById(@PathVariable Long id){
		
		try {
		return ResponseEntity.ok(deviceTypeEntityService.getDeviceTypeEntityById(id));
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/devicetypes")
	public ResponseEntity<List<DeviceTypeEntity>> getAllDeviceTypeEntity(){
		
		try {
			return ResponseEntity.ok(deviceTypeEntityService.getAllDeviceTypeEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/devicetypes")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceTypeEntity> addDeviceTypeEntity(@RequestBody DeviceTypeEntity deviceType){
		
		try {
			return new ResponseEntity<>(deviceTypeEntityService.addDeviceTypeEntity(deviceType),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/devicetypes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceTypeEntity> editDeviceTypeEntity(@PathVariable Long id,@RequestBody DeviceTypeEntity deviceType){
		
		try {
			return new ResponseEntity<>(deviceTypeEntityService.editDeviceTypeEntity(id, deviceType),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/devicetypes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteDeviceTypeEntityById(@PathVariable Long id){
		
		try {
			deviceTypeEntityService.deleteDeviceTypeEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
