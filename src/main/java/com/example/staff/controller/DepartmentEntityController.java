package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.DepartmentEntity;
import com.example.staff.service.DepartmentEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DepartmentEntityController {

private final DepartmentEntityService departmentEntityService;
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<DepartmentEntity> getDepartmentEntityById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(departmentEntityService.getDepartmentEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentEntity>> getAllDepartmentEntity(){
		try {
			return ResponseEntity.ok(departmentEntityService.getAllDepartmentEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/departments")
	public ResponseEntity<DepartmentEntity> addDepartmentEntity(@RequestBody DepartmentEntity departmentEntity){
		try {
			return new ResponseEntity<>(departmentEntityService.addDepartmentEntity(departmentEntity),HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<DepartmentEntity> editDepartmentEntity(@PathVariable Long id,@RequestBody DepartmentEntity departmentEntity){
		try {
			return new ResponseEntity<>(departmentEntityService.editDepartmentEntity(id, departmentEntity),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<HttpStatus> deleteDepartmentEntityById(@PathVariable Long id){
		try {
			departmentEntityService.deleteDepartmentEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
}
