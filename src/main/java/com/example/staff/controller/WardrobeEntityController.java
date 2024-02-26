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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.WardrobeEntity;
import com.example.staff.service.WardrobeEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WardrobeEntityController {

private final WardrobeEntityService wardrobeEntityService;
	
	@GetMapping("/wardrobes/{id}")
	public ResponseEntity<WardrobeEntity> getWardrobeEntityById(@PathVariable Long id){
		
		try {return ResponseEntity.ok(wardrobeEntityService.getWardrobeEntityById(id));}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/wardrobes")
	public ResponseEntity<List<WardrobeEntity>> findByNumberEmployeeRoomFree(@RequestParam(required=false) String filter){
		
		if(filter!=null && filter.trim().length()!=0) {
			String filter1=filter;
			String filter2=filter;
			String filter3=filter;
			try {
				return ResponseEntity.ok(wardrobeEntityService.findByNumberEmployeeRoom(filter1,filter2,filter3));
			} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
		}else {
			try {
				return ResponseEntity.ok(wardrobeEntityService.getAllWardrobeEntity());
			} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
		}
	}
	
	@GetMapping("/wardrobes/employeesid/{id}")
	public ResponseEntity<List<WardrobeEntity>> findWardrobeByEmployeeId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(wardrobeEntityService.findWardrobeByEmployeeId(id));
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/wardrobes")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<WardrobeEntity> addWardrobeEntity(@RequestBody WardrobeEntity wardrobe){
		
		try {return new ResponseEntity<>(wardrobeEntityService.addWardrobeEntity(wardrobe), HttpStatus.CREATED);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/wardrobes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<WardrobeEntity> editWardrobeEntity(@PathVariable Long id, @RequestBody WardrobeEntity wardrobe){
		
		try {return new ResponseEntity<>(wardrobeEntityService.editWardrobeEntity(id, wardrobe), HttpStatus.OK);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PatchMapping("/wardrobes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<WardrobeEntity> updateWardrobeEntity(@PathVariable Long id,@RequestBody WardrobeEntity wardrobe) {
		try {
			return new ResponseEntity<>(wardrobeEntityService.editWardrobeEntity(id, wardrobe),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/wardrobes/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteWardrobeEntityById(@PathVariable Long id){
		
		try {
			wardrobeEntityService.deleteWardrobeEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
