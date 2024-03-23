package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.WardrobeEntity;

public interface WardrobeEntityService {

	WardrobeEntity getWardrobeEntityById(Long id);
	List<WardrobeEntity> getAllWardrobeEntity();
	WardrobeEntity addWardrobeEntity(WardrobeEntity wardrobeEntity);
	WardrobeEntity editWardrobeEntity(Long id, WardrobeEntity wardrobeEntity);
	void deleteWardrobeEntityById(Long id);
	List<WardrobeEntity> findByNumberEmployeeRoom(int filter1, String filter2, String filter3);
	List<WardrobeEntity> findWardrobeByEmployeeId(Long id);
}
