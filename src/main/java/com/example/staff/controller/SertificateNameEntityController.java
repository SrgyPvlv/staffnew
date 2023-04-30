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

import com.example.staff.entity.SertificateNameEntity;
import com.example.staff.service.SertificateNameEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SertificateNameEntityController {

private final SertificateNameEntityService sertificateNameEntityService;
	
	@GetMapping("/sertificatenames/{id}")
	public ResponseEntity<SertificateNameEntity> getSertificateNameEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(sertificateNameEntityService.getSertificateNameEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/sertificatenames")
	public ResponseEntity<List<SertificateNameEntity>> getAllSertificateNameEntity(){
		try {
			return ResponseEntity.ok(sertificateNameEntityService.getAllSertificateNameEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/sertificatenames")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<SertificateNameEntity> addSertificateNameEntity(@RequestBody SertificateNameEntity sertificateName){
		try {
			return new ResponseEntity<>(sertificateNameEntityService.addSertificateNameEntity(sertificateName),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/sertificatenames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<SertificateNameEntity> editSertificateNameEntity(@PathVariable Long id,@RequestBody SertificateNameEntity sertificateName){
		try {
			return new ResponseEntity<>(sertificateNameEntityService.editSertificateNameEntity(id, sertificateName),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/sertificatenames/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteSertificateNameEntityById(@PathVariable Long id){
		try {
			sertificateNameEntityService.deleteSertificateNameEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
