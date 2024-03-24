package com.example.staff.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.SertificateEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.SertificateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultSertificateService implements SertificateService {

	private final SertificateRepository sertificateRepository;

	@Override
	public SertificateEntity getSertificateEntityById(Long id) {
		
		SertificateEntity sertificate=sertificateRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Sertificate not found: id = "+ id));
		return sertificate;
	}

	@Override
	public List<SertificateEntity> getAllSertificateEntity() {
		
		return sertificateRepository.findAll(Sort.by(Sort.Direction.ASC,"sertificateName"));
	}

	@Override
	public SertificateEntity addSertificateEntity(SertificateEntity sertificate) {
		
		return sertificateRepository.saveAndFlush(sertificate);
	}

	@Override
	public SertificateEntity editSertificateEntity(Long id, SertificateEntity sertificate) {
		
		SertificateEntity editedSertificate=sertificateRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Sertificate not found: id = "+ id));
		editedSertificate.setSertificateName(sertificate.getSertificateName());
		editedSertificate.setSertificateNumber(sertificate.getSertificateNumber());
		editedSertificate.setApprovalGruppa(sertificate.getApprovalGruppa());
		editedSertificate.setIssueDate(sertificate.getIssueDate());
		editedSertificate.setExpirationDate(sertificate.getExpirationDate());
		
		return sertificateRepository.saveAndFlush(editedSertificate);
	}

	@Override
	public void deleteSertificateEntityById(Long id) {
		
		sertificateRepository.deleteById(id);	
	}

	@Override
	public List<SertificateEntity> findSertificatesByEmployeeId(Long id) {
		
		return sertificateRepository.findByEmployeeId(id);
	}
}
