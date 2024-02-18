package com.example.staff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.service.AvatarEntityService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins="http://localhost:5173/")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AvatarController {

	private final AvatarEntityService avatarEntityService;
	
	@PostMapping("/avatars/{id}")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
	public ResponseEntity<HttpStatus> updateAvatar(@PathVariable Long id, @RequestParam("avatar") MultipartFile avatar){
		
		try {
			avatarEntityService.saveAvatar(id, avatar.getContentType(), avatar);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@GetMapping("/avatars/{id}")
	public ResponseEntity<byte []> getAvatar(@PathVariable Long id){
		String contentType = avatarEntityService.getContentTypeByEmployeeId(id)
				.orElseThrow(() -> new ItemNotFoundException("ContentType not found: id = " + id));
		byte[] data = avatarEntityService.getAvatarEntityByEmployeeId(id)
				.orElseThrow(() -> new ItemNotFoundException("File not found: id = " + id));
		try{return ResponseEntity
				.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(data);} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
}
