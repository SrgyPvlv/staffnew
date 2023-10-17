package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ReferenceEntity;

public interface ReferenceEntityService {

	ReferenceEntity getReferenceById(Long id);
	List<ReferenceEntity> getAllReferences();
	ReferenceEntity addReference(ReferenceEntity reference);
	ReferenceEntity editReference(Long id,ReferenceEntity reference);
	void deleteReferenceById(Long id);
}
