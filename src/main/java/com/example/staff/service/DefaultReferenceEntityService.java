package com.example.staff.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.ReferenceEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.ReferenceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultReferenceEntityService implements ReferenceEntityService {

	private final ReferenceRepository referenceRepository;
	
	@Override
	public ReferenceEntity getReferenceById(Long id) {
		
		ReferenceEntity reference=referenceRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Reference not found: id = "+ id));
		return reference;
	}

	@Override
	public List<ReferenceEntity> getAllReferences() {
		
		return referenceRepository.findAll(Sort.by(Sort.Direction.ASC,"referenceName"));
	}

	@Override
	public ReferenceEntity addReference(ReferenceEntity reference) {
		
		return referenceRepository.saveAndFlush(reference);
	}

	@Override
	public ReferenceEntity editReference(Long id, ReferenceEntity reference) {
		
		ReferenceEntity editedReference=referenceRepository
				.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Reference not found: id = "+ id));
		editedReference.setReferenceName(reference.getReferenceName());
		editedReference.setReferenceAddress(reference.getReferenceAddress());
		editedReference.setReferenceOverview(reference.getReferenceOverview());
		editedReference.setReferenceTheme(reference.getReferenceTheme());
		
		return referenceRepository.saveAndFlush(editedReference);
	}

	@Override
	public void deleteReferenceById(Long id) {
		referenceRepository.deleteById(id);
		
	}

}
