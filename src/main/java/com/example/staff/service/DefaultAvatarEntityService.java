package com.example.staff.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.staff.entity.AvatarEntity;
import com.example.staff.entity.EmployeeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.AvatarRepository;
import com.example.staff.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultAvatarEntityService implements AvatarEntityService {

	private final AvatarRepository avatarRepository;
	private final EmployeeRepository employeeRepository;
	
	//private static String HOME = System.getProperty("user.home");
	
	@Value("${file.storage.path}")
	private String path;
	
	@Override
	@Transactional
	public void saveAvatar(Long employeeId, String contentType, MultipartFile file) {
		
		Optional<AvatarEntity> avatarOpt = Optional.ofNullable(avatarRepository.findByEmployeeId(employeeId));
		AvatarEntity avatar;
		String filename;
		
		if(!avatarOpt.isPresent()) {
			filename = UUID.randomUUID().toString()+".jpg";
			EmployeeEntity employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ItemNotFoundException("Employee not found: id = " + employeeId));
			avatar = new AvatarEntity(null, contentType, filename, employee);
		} else {
			avatar = avatarOpt.get();
			filename = avatar.getFileName();
			avatar.setContentType(contentType);
		}
		
		avatarRepository.save(avatar);
		
        Path destPath = Paths.get(path,filename);
        System.out.println("destPath = " + destPath);
        						
			try {	InputStream is = file.getInputStream();
			Files.copy(is, destPath, StandardCopyOption.REPLACE_EXISTING);
			is.close();
			
		} catch (IOException ex) {throw new IllegalStateException(ex);}

	}

	@Override
	public String getContentTypeByEmployeeId(Long id) {
		
		Optional<AvatarEntity> avatarOpt = Optional.ofNullable(avatarRepository.findByEmployeeId(id));
		return avatarOpt.map(AvatarEntity::getContentType).orElseThrow(() -> new ItemNotFoundException("ContentType not found: id = " + id));
	}

	@Override
	public byte[] getAvatarEntityByEmployeeId(Long id) {
		
		Optional<AvatarEntity> avatarOpt = Optional.ofNullable(avatarRepository.findByEmployeeId(id));
		return avatarOpt.map(AvatarEntity::getFileName).map(filename ->{
			try {return Files.readAllBytes(Paths.get(path,filename));} catch (Exception ex) {throw new IllegalStateException(ex);}
		})
				.orElseThrow(() -> new ItemNotFoundException("File not found: id = " + id));
	}

	@Override
	public void deleteAvatarEntityByEmployeeId(Long id) {
		
		Optional<AvatarEntity> avatarOpt = Optional.ofNullable(avatarRepository.findByEmployeeId(id));
		AvatarEntity avatar = avatarOpt.get();
		String filename = avatar.getFileName();
		Long avatarId = avatar.getId();
		Path destPath = Paths.get(path,filename);
		try {Files.delete(destPath);avatarRepository.deleteById(avatarId);} catch (Exception ex) {throw new RuntimeException(ex);}
		
		//avatarRepository.deleteAvatarByEmployeeId(id);
	}
}
