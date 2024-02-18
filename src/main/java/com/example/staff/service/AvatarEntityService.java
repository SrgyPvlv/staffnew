package com.example.staff.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarEntityService {
	
	void saveAvatar(Long employeeId, String contentType, MultipartFile file);
	Optional<String> getContentTypeByEmployeeId(Long id);
	Optional<byte[]> getAvatarEntityByEmployeeId(Long id);
}
