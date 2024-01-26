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

import com.example.staff.entity.ToolTypeEntity;
import com.example.staff.service.ToolTypeEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ToolTypeEntityController {

	private final ToolTypeEntityService toolTypeEntityService;
	
	@GetMapping("/tooltypes/{id}")
	public ResponseEntity<ToolTypeEntity> getToolTypeEntityById(@PathVariable Long id){
	
	try {return ResponseEntity.ok(toolTypeEntityService.getToolTypeEntityById(id));}
	catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/tooltypes")
	public ResponseEntity<List<ToolTypeEntity>> getAllToolTypeEntity(){
		
		try {return ResponseEntity.ok(toolTypeEntityService.getAllToolTypeEntity());}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/tooltypes")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolTypeEntity> addToolTypeEntity(@RequestBody ToolTypeEntity toolType){
		 
		try {return new ResponseEntity<>(toolTypeEntityService.addToolTypeEntity(toolType), HttpStatus.CREATED);}
		 catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/tooltypes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolTypeEntity> editToolTypeEntity(@PathVariable Long id, @RequestBody ToolTypeEntity toolType){
		
		try {return new ResponseEntity<>(toolTypeEntityService.editToolTypeEntity(id, toolType), HttpStatus.OK);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/tooltype/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteToolTypeEntity(@PathVariable Long id){
		
		try {toolTypeEntityService.deleteToolTypeEntity(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
