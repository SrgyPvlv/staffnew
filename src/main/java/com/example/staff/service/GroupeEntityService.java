package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.GroupeEntity;

public interface GroupeEntityService {

	GroupeEntity getGroupeEntityById(Long id);
	List<GroupeEntity> getAllGroupeEntity();
	GroupeEntity addGroupeEntity(GroupeEntity groupeEntity);
	GroupeEntity editGroupeEntity(Long id,GroupeEntity groupeEntity);
	void deleteGroupeEntityById(Long id);
}
