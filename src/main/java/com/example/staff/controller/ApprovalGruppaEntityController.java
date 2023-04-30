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

import com.example.staff.entity.ApprovalGruppaEntity;
import com.example.staff.service.ApprovalGruppaEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ApprovalGruppaEntityController {

private final ApprovalGruppaEntityService approvalGruppaEntityService;
	
	@GetMapping("/approvalgruppas/{id}")
	public ResponseEntity<ApprovalGruppaEntity> getApprovalGruppaEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(approvalGruppaEntityService.getApprovalGruppaEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/approvalgruppas")
	public ResponseEntity<List<ApprovalGruppaEntity>> getAllApprovalGruppaEntity(){
		try {
			return ResponseEntity.ok(approvalGruppaEntityService.getAllApprovalGruppaEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/approvalgruppas")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ApprovalGruppaEntity> addApprovalGruppaEntity(@RequestBody ApprovalGruppaEntity approvalGruppa){
		try {
			return new ResponseEntity<>(approvalGruppaEntityService.addApprovalGruppaEntity(approvalGruppa),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/approvalgruppas/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ApprovalGruppaEntity> editApprovalGruppaEntity(@PathVariable Long id,@RequestBody ApprovalGruppaEntity approvalGruppa){
		try {
			return new ResponseEntity<>(approvalGruppaEntityService.editApprovalGruppaEntity(id, approvalGruppa),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/approvalgruppas/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteApprovalGruppaEntityById(@PathVariable Long id){
		try {
			approvalGruppaEntityService.deleteApprovalGruppaEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
