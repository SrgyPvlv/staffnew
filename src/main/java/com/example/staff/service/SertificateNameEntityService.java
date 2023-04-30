package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.SertificateNameEntity;

public interface SertificateNameEntityService {

	SertificateNameEntity getSertificateNameEntityById(Long id);
	List<SertificateNameEntity> getAllSertificateNameEntity();
	SertificateNameEntity addSertificateNameEntity(SertificateNameEntity sertificateName);
	SertificateNameEntity editSertificateNameEntity(Long id, SertificateNameEntity sertificateName);
	void deleteSertificateNameEntityById(Long id);
}
