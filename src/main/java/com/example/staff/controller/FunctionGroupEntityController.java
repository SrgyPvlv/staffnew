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

import com.example.staff.entity.FunctionGroupEntity;
import com.example.staff.service.FunctionGroupEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FunctionGroupEntityController {

private final FunctionGroupEntityService functionGroupEntityService;
	
	@GetMapping("/function-groups/{id}")
	public ResponseEntity<FunctionGroupEntity> getFunctionGroupEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(functionGroupEntityService.getFunctionGroupEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/function-groups")
	public ResponseEntity<List<FunctionGroupEntity>> getAllFunctionGroupEntity(){
		try {
			return ResponseEntity.ok(functionGroupEntityService.getAllFunctionGroupEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/function-groups")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<FunctionGroupEntity> addFunctionGroupEntity(@RequestBody FunctionGroupEntity functionGroupEntity){
		try {
			return new ResponseEntity<>(functionGroupEntityService.addFunctionGroupEntity(functionGroupEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/function-groups/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<FunctionGroupEntity> editFunctionGroupEntity(@PathVariable Long id,@RequestBody FunctionGroupEntity functionGroupEntity){
		try {
			return new ResponseEntity<>(functionGroupEntityService.editFunctionGroupEntity(id, functionGroupEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/function-groups/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteFunctionGroupEntityById(@PathVariable Long id){
		try {
			functionGroupEntityService.deleteFunctionGroupEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
