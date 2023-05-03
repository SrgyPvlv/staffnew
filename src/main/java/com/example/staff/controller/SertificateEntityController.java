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

import com.example.staff.entity.SertificateEntity;
import com.example.staff.service.SertificateService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SertificateEntityController {

private final SertificateService sertificateService;
	
	@GetMapping("/sertificates/{id}")
	public ResponseEntity<SertificateEntity> getSertificateEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(sertificateService.getSertificateEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/sertificates")
	public ResponseEntity<List<SertificateEntity>> getAllSertificateEntity(){
		try {
			return ResponseEntity.ok(sertificateService.getAllSertificateEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/sertificates/employeesid/{id}")
	public ResponseEntity<List<SertificateEntity>> findSertificatesByEmployeeId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(sertificateService.findSertificatesByEmployeeId(id));
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/sertificates")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<SertificateEntity> addSertificateEntity(@RequestBody SertificateEntity sertificate){
		try {
			return new ResponseEntity<>(sertificateService.addSertificateEntity(sertificate),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/sertificates/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<SertificateEntity> editSertificateEntity(@PathVariable Long id,@RequestBody SertificateEntity sertificate){
		try {
			return new ResponseEntity<>(sertificateService.editSertificateEntity(id, sertificate),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/sertificates/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteSertificateEntityById(@PathVariable Long id){
		try {
			sertificateService.deleteSertificateEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
