package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.SertificateEntity;

public interface SertificateService {

	SertificateEntity getSertificateEntityById(Long id);
	List<SertificateEntity> getAllSertificateEntity();
	SertificateEntity addSertificateEntity(SertificateEntity sertificate);
	SertificateEntity editSertificateEntity(Long id, SertificateEntity sertificate);
	void deleteSertificateEntityById(Long id);
}
