package com.example.staff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
