package com.example.staff.service;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarEntityService {
	
	void saveAvatar(Long employeeId, String contentType, MultipartFile file);
	String getContentTypeByEmployeeId(Long id);
	byte[] getAvatarEntityByEmployeeId(Long id);
	void deleteAvatarEntityByEmployeeId(Long id);
}
