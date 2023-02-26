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

import com.example.staff.entity.DivisionEntity;
import com.example.staff.service.DivisionEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DivisionEntityController {

private final DivisionEntityService divisionEntityService;
	
	@GetMapping("/divisions/{id}")
	public ResponseEntity<DivisionEntity> getDivisionEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(divisionEntityService.getDivisionEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/divisions")
	public ResponseEntity<List<DivisionEntity>> getAllDivisionEntity(){
		try {
			return ResponseEntity.ok(divisionEntityService.getAllDivisionEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/divisions")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DivisionEntity> addDivisionEntity(@RequestBody DivisionEntity divisionEntity){
		try {
			return new ResponseEntity<>(divisionEntityService.addDivisionEntity(divisionEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/divisions/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DivisionEntity> editDivisionEntity(@PathVariable Long id,@RequestBody DivisionEntity divisionEntity){
		try {
			return new ResponseEntity<>(divisionEntityService.editDivisionEntity(id, divisionEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/divisions/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteDivisionEntityById(@PathVariable Long id){
		try {
			divisionEntityService.deleteDivisionEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
