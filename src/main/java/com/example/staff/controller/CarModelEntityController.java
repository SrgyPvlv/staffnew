package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.CarModelEntity;
import com.example.staff.service.CarModelEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CarModelEntityController {

	private final CarModelEntityService carModelEntityService;
	
	@GetMapping("/carmodels/{id}")
	public ResponseEntity<CarModelEntity> getCarModelEntityById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(carModelEntityService.getCarModelEntityById(id), HttpStatus.OK);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/carmodels")
	public ResponseEntity<List<CarModelEntity>> getAllCarModelEntity(){
		try {
			return new ResponseEntity<>(carModelEntityService.getAllCarModelEntity(), HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/carmodels")
	public ResponseEntity<CarModelEntity> addCarModelEntity(@RequestBody CarModelEntity carModelEntity){
		try {	
			return new ResponseEntity<>(carModelEntityService.addCarModelEntity(carModelEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/carmodels/{id}")
	public ResponseEntity<CarModelEntity> editCarModelEntity(@PathVariable Long id, @RequestBody CarModelEntity carModelEntity){
		try {
			return new ResponseEntity<>(carModelEntityService.editCarModelEntity(id, carModelEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/carmodels/{id}")
	public ResponseEntity<HttpStatus> deleteCarModelEntityById(@PathVariable Long id){
		try {
			carModelEntityService.deleteCarModelEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
