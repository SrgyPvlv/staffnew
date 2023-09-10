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

import com.example.staff.entity.DeviceEntity;
import com.example.staff.service.DeviceEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DeviceEntityController {

	private final DeviceEntityService deviceEntityService;

	@GetMapping("/devices/{id}")
	public ResponseEntity<DeviceEntity> getDeviceEntityById(@PathVariable Long id){
		
		try {
			return ResponseEntity.ok(deviceEntityService.getDeviceEntityById(id));
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/devices")
	public ResponseEntity<List<DeviceEntity>> getAllDeviceNameEntity() {
		try {
			return ResponseEntity.ok(deviceEntityService.getAllDeviceEntity());
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/devices/employeesid/{id}")
	public ResponseEntity<List<DeviceEntity>> findDevicesByEmployeeId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(deviceEntityService.findDevicesByEmployeeId(id));
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/devices")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceEntity> addDeviceNameEntity(@RequestBody DeviceEntity device) {
		try {
			return new ResponseEntity<>(deviceEntityService.addDeviceEntity(device),HttpStatus.CREATED);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/devices/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<DeviceEntity> editDeviceNameEntity(@PathVariable Long id,@RequestBody DeviceEntity device) {
		try {
			return new ResponseEntity<>(deviceEntityService.editDeviceEntity(id, device),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/devices/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteDeviceEntityById(@PathVariable Long id) {
		
		try {
			deviceEntityService.deleteDeviceEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
