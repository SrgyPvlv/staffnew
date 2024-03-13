package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.PositionEntity;
import com.example.staff.service.PositionEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PositionEntityController {

	private final PositionEntityService positionEntityService;
	
	@GetMapping("/positions/{id}")
	public ResponseEntity<PositionEntity> getPositionEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(positionEntityService.getPositionEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/positions")
	public ResponseEntity<List<PositionEntity>> getAllPositionEntity(){
		try {
			return ResponseEntity.ok(positionEntityService.getAllPositionEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/positions")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<PositionEntity> addPositionEntity(@RequestBody PositionEntity positionEntity){
		try {
			return new ResponseEntity<>(positionEntityService.addPositionEntity(positionEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/positions/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<PositionEntity> editPositionEntity(@PathVariable Long id,@RequestBody PositionEntity positionEntity){
		try {
			return new ResponseEntity<>(positionEntityService.editPositionEntity(id, positionEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PatchMapping("/positions/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<PositionEntity> updatePositionEntity(@PathVariable Long id,@RequestBody PositionEntity positionEntity){
		try {
			return new ResponseEntity<>(positionEntityService.editPositionEntity(id, positionEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/positions/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deletePositionEntityById(@PathVariable Long id){
		try {
			positionEntityService.deletePositionEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
