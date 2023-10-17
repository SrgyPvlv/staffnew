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

import com.example.staff.entity.ReferenceEntity;
import com.example.staff.service.ReferenceEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReferenceEntityController {

private final ReferenceEntityService referenceEntityService;
	
	@GetMapping("/references/{id}")
	public ResponseEntity<ReferenceEntity> getReferenceById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(referenceEntityService.getReferenceById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/references")
	public ResponseEntity<List<ReferenceEntity>> getAllReferences(){
		try {
			return ResponseEntity.ok(referenceEntityService.getAllReferences());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/references")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ReferenceEntity> addReference(@RequestBody ReferenceEntity referenceEntity){
		try {
			return new ResponseEntity<>(referenceEntityService.addReference(referenceEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/references/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ReferenceEntity> editReference(@PathVariable Long id,@RequestBody ReferenceEntity referenceEntity){
		try {
			return new ResponseEntity<>(referenceEntityService.editReference(id, referenceEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/references/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteReferenceById(@PathVariable Long id){
		try {
			referenceEntityService.deleteReferenceById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
