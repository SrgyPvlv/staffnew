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

import com.example.staff.entity.ToolNameEntity;
import com.example.staff.service.ToolNameEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ToolNameEntityController {

	private final ToolNameEntityService toolNameEntityService;
	
	@GetMapping("/toolnames/{id}")
	public ResponseEntity<ToolNameEntity> getToolNameEntityById(@PathVariable Long id){
		
		try {return ResponseEntity.ok(toolNameEntityService.getToolNameEntityById(id));}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/toolnames")
	public ResponseEntity<List<ToolNameEntity>> getAllToolNameEntity(){
		
		try {return ResponseEntity.ok(toolNameEntityService.getAllToolNameEntity());}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/toolnames")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolNameEntity> addToolNameEntity(@RequestBody ToolNameEntity toolName){
		
		try {return new ResponseEntity<>(toolNameEntityService.addToolNameEntity(toolName), HttpStatus.CREATED);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/toolnames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolNameEntity> editToolNameEntity(@PathVariable Long id, @RequestBody ToolNameEntity toolName){
		
		try {return new ResponseEntity<>(toolNameEntityService.editToolNameEntity(id, toolName), HttpStatus.OK);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/toolnames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteToolNameEntity(@PathVariable Long id){
		
		try {
			toolNameEntityService.deleteToolNameEntity(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
