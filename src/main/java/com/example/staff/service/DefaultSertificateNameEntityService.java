package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.staff.entity.SertificateNameEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.SertificateNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultSertificateNameEntityService implements SertificateNameEntityService {
	
	private final SertificateNameRepository sertificateNameRepository;

	@Override
	public SertificateNameEntity getSertificateNameEntityById(Long id) {
		
		SertificateNameEntity sertificateName=sertificateNameRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("SertificateName not found: id = "+ id));
		return sertificateName;
	}

	@Override
	public List<SertificateNameEntity> getAllSertificateNameEntity() {
		
		return sertificateNameRepository.findAll();
	}

	@Override
	public SertificateNameEntity addSertificateNameEntity(SertificateNameEntity sertificateName) {
		
		return sertificateNameRepository.saveAndFlush(sertificateName);
	}

	@Override
	public SertificateNameEntity editSertificateNameEntity(Long id, SertificateNameEntity sertificateName) {
		
		SertificateNameEntity editedsertificateName=sertificateNameRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("SertificateName not found: id = "+ id));
		editedsertificateName.setSertificateName(sertificateName.getSertificateName());
		
		return sertificateNameRepository.saveAndFlush(editedsertificateName);
	}

	@Override
	public void deleteSertificateNameEntityById(Long id) {
		sertificateNameRepository.deleteById(id);
		
	}

}
