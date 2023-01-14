package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.staff.entity.GroupeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.GroupeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultGroupeEntityService implements GroupeEntityService {

private final GroupeRepository groupeRepository;
	
	@Override
	public GroupeEntity getGroupeEntityById(@PathVariable Long id) {
		
		GroupeEntity groupeEntity=groupeRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Groupe not found: id = "+ id));
		return groupeEntity;
	}

	@Override
	public List<GroupeEntity> getAllGroupeEntity() {
		
		return groupeRepository.findAll();
	}

	@Override
	public GroupeEntity addGroupeEntity(GroupeEntity groupeEntity) {
		
		return groupeRepository.saveAndFlush(groupeEntity);
	}

	@Override
	public GroupeEntity editGroupeEntity(@PathVariable Long id, @RequestBody GroupeEntity groupeEntity) {
		GroupeEntity editedGroupeEntity=groupeRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("Groupe not found: id = "+ id));
		editedGroupeEntity.setGroupe(groupeEntity.getGroupe());
		
		return groupeRepository.saveAndFlush(editedGroupeEntity);
	}

	@Override
	public void deleteGroupeEntityById(@PathVariable Long id) {
		groupeRepository.deleteById(id);
		
	}
}
