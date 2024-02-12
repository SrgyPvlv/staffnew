package com.example.staff.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarEntityService {
	
	void saveAvatar(Long employeeId, String contentType, MultipartFile file);
}
