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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.service.AvatarEntityService;
import com.example.staff.service.EmployeeEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@SessionScope
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeEntityController {

	private final EmployeeEntityService employeeEntityService;
	private final AvatarEntityService avatarEntityService;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeEntityById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(employeeEntityService.getEmployeeEntityById(id),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
		
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeEntity>> findByNameMobilePosition(@RequestParam(required=false) String filter){
		
		if(filter!=null && filter.trim().length()!=0) {
			String filter1=filter;
			String filter2=filter;
			String filter3=filter;
			try {return new ResponseEntity<>(employeeEntityService.findByNameMobilePositionContaining(filter1,filter2,filter3),HttpStatus.OK);
			}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
		}else {
			try {
				return new ResponseEntity<>(employeeEntityService.getAllEmployeeEntity(),HttpStatus.OK);
				} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}			
		}
	}
	
	@GetMapping("/employees/factdepartment")
	public ResponseEntity<List<EmployeeEntity>> findByGroupeOrFunctionGroupOrderByNameAsc(@RequestParam(required=false) String filter){
		
			String filter1=filter;
			String filter2=filter;
			String filter3=filter;
			try {return new ResponseEntity<>(employeeEntityService.findByFactDivisionOrGroupeOrFunctionGroupOrderByNameAsc(filter1,filter2,filter3),HttpStatus.OK);
			}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/employees/staffdepartment")
	public ResponseEntity<List<EmployeeEntity>> findByStaffGroupeOrFunctionGroupOrderByNameAsc(@RequestParam(required=false) String filter){
		
			String filter1=filter;
			String filter2=filter;
			String filter3=filter;
			try {return new ResponseEntity<>(employeeEntityService.findByStaffDivisionOrGroupeOrFunctionGroupOrderByNameAsc(filter1,filter2,filter3),HttpStatus.OK);
			}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/employees/factDepartmentOrPosition")
	public ResponseEntity<List<EmployeeEntity>> findByFactDepartmentOrPositionIn(@RequestParam(required=false) List<String> filterDepartment,
			@RequestParam(required=false) List<String> filterPosition){
				
		List<String> filter1=filterDepartment;
		List<String> filter2=filterDepartment;
		List<String> filter3=filterDepartment;
		List<String> filter4=filterPosition;
		
			try {return new ResponseEntity<>(employeeEntityService.findByFactDepartmentOrPositionIn(filter1,filter2,filter3,filter4),HttpStatus.OK);
			}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
		
	@PostMapping("/employees")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<EmployeeEntity> addEmployeeEntity(@RequestBody EmployeeEntity employeeEntity){
		try {
			return new ResponseEntity<>(employeeEntityService.addEmployeeEntity(employeeEntity),HttpStatus.CREATED);
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/employees/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<EmployeeEntity> editEmployeeEntity(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity){
		try {
			return new ResponseEntity<>(employeeEntityService.editEmployeeEntity(id, employeeEntity),HttpStatus.OK);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/employees/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteEmployEntityById(@PathVariable Long id){
		try {
			avatarEntityService.deleteAvatarEntityByEmployeeId(id);
			employeeEntityService.deleteEmployEntityById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
