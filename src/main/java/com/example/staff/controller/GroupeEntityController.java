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

import com.example.staff.entity.GroupeEntity;
import com.example.staff.service.GroupeEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class GroupeEntityController {

private final GroupeEntityService groupeEntityService;
	
	@GetMapping("/groupes/{id}")
	public ResponseEntity<GroupeEntity> getGroupeEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(groupeEntityService.getGroupeEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/groupes")
	public ResponseEntity<List<GroupeEntity>> getAllGroupeEntity(){
		try {
			return ResponseEntity.ok(groupeEntityService.getAllGroupeEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/groupes")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<GroupeEntity> addGroupeEntity(@RequestBody GroupeEntity groupeEntity){
		try {
			return new ResponseEntity<>(groupeEntityService.addGroupeEntity(groupeEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/groupes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<GroupeEntity> editGroupeEntity(@PathVariable Long id,@RequestBody GroupeEntity groupeEntity){
		try {
			return new ResponseEntity<>(groupeEntityService.editGroupeEntity(id, groupeEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/groupes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteGroupeEntityById(@PathVariable Long id){
		try {
			groupeEntityService.deleteGroupeEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
