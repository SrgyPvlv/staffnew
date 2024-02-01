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

import com.example.staff.entity.DeviceEntity;
import com.example.staff.entity.ToolEntity;
import com.example.staff.service.ToolEntityService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ToolEntityController {

private final ToolEntityService toolEntityService;
	
	@GetMapping("/tools/{id}")
	public ResponseEntity<ToolEntity> getToolEntityById(@PathVariable Long id){
		
		try {return ResponseEntity.ok(toolEntityService.getToolEntityById(id));}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/tools")
	public ResponseEntity<List<ToolEntity>> findByNumberTypeNameEmployeeCommentPlace(@RequestParam(required=false) String filter){
		
		if(filter!=null && filter.trim().length()!=0) {
			String filter1=filter;
			String filter2=filter;
			String filter3=filter;
			String filter4=filter;
			String filter5=filter;
			String filter6=filter;
			try {
				return ResponseEntity.ok(toolEntityService.findByNumberTypeNameEmployeeCommentPlace(filter1,filter2,filter3,filter4,filter5,filter6));
			} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
		}else {
			try {
				return ResponseEntity.ok(toolEntityService.getAllToolEntity());
			} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
		}
	}
	
	@GetMapping("/tools/employeesid/{id}")
	public ResponseEntity<List<ToolEntity>> findDevicesByEmployeeId(@PathVariable Long id){
		try {
			return ResponseEntity.ok(toolEntityService.findToolsByEmployeeId(id));
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/tools")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolEntity> addToolEntity(@RequestBody ToolEntity tool){
		
		try {return new ResponseEntity<>(toolEntityService.addToolEntity(tool), HttpStatus.CREATED);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/tools/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<ToolEntity> editToolEntity(@PathVariable Long id, @RequestBody ToolEntity tool){
		
		try {return new ResponseEntity<>(toolEntityService.editToolEntity(id, tool), HttpStatus.OK);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PatchMapping("/tools/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN') or hasRole('TESTER')")
	public ResponseEntity<ToolEntity> updateToolEntity(@PathVariable Long id,@RequestBody ToolEntity tool) {
		try {
			return new ResponseEntity<>(toolEntityService.editToolEntity(id, tool),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@DeleteMapping("/tools/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> deleteToolEntity(@PathVariable Long id){
		
		try {
			toolEntityService.deleteToolEntity(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
		catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
}
