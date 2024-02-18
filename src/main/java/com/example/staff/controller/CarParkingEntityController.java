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

import com.example.staff.entity.CarParkingEntity;
import com.example.staff.service.CarParkingEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CarParkingEntityController {

	private CarParkingEntityService carParkingEntityService;
	
	@GetMapping("/carparkings/{id}")
	public ResponseEntity<CarParkingEntity> getCarParkingEntityById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(carParkingEntityService.getCarParkingEntityById(id), HttpStatus.OK);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/carparkings")
	public ResponseEntity<List<CarParkingEntity>> getAllCarParkingEntity(){
		try {
			return new ResponseEntity<>(carParkingEntityService.getAllCarParkingEntity(), HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/carparkings")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<CarParkingEntity> addCarParkingEntity(@RequestBody CarParkingEntity carParkingEntity){
		try {	
			return new ResponseEntity<>(carParkingEntityService.addCarParkingEntity(carParkingEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/carparkings/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<CarParkingEntity> editCarParkingEntity(@PathVariable Long id, @RequestBody CarParkingEntity carParkingEntity){
		try {
			return new ResponseEntity<>(carParkingEntityService.editCarParkingEntity(id, carParkingEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/carparkings/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteCarParkingEntityById(@PathVariable Long id){
		try {
			carParkingEntityService.deleteCarParkingEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
