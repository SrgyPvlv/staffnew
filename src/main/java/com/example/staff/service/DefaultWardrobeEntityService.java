package com.example.staff.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.staff.entity.WardrobeEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.WardrobeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultWardrobeEntityService implements WardrobeEntityService {

	private final WardrobeRepository wardrobeRepository;
	
	@Override
	public WardrobeEntity getWardrobeEntityById(Long id) {
		
		WardrobeEntity wardrobe = wardrobeRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Wardrobe not found id: " + id));
		return wardrobe;
	}

	@Override
	public List<WardrobeEntity> getAllWardrobeEntity() {
		
		return wardrobeRepository.findAll(Sort.by(Sort.Direction.ASC,"number"));
	}

	@Override
	public WardrobeEntity addWardrobeEntity(WardrobeEntity wardrobeEntity) {
		
		return wardrobeRepository.saveAndFlush(wardrobeEntity);
	}

	@Override
	public WardrobeEntity editWardrobeEntity(Long id, WardrobeEntity wardrobeEntity) {
		
		WardrobeEntity  editedWardrobe = wardrobeRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Wardrobe not found id: " + id));
		editedWardrobe.setNumber(wardrobeEntity.getNumber());
		editedWardrobe.setEmployee(wardrobeEntity.getEmployee());
		editedWardrobe.setRoom(wardrobeEntity.getRoom());
		editedWardrobe.setFree(wardrobeEntity.isFree());
		editedWardrobe.setComment(wardrobeEntity.getComment());
		
		return wardrobeRepository.saveAndFlush(editedWardrobe);
	}

	@Override
	public void deleteWardrobeEntityById(Long id) {
		
		wardrobeRepository.deleteById(id);
	}

	@Override
	public List<WardrobeEntity> findByNumberEmployeeRoom(int filter1, String filter2, String filter3) {
		
		return wardrobeRepository.findByNumberEqualsOrEmployeeNameIgnoreCaseContainingOrRoomIgnoreCaseContainingOrderByNumberAsc(filter1, filter2, filter3);
	}

	@Override
	public List<WardrobeEntity> findWardrobeByEmployeeId(Long id) {
		
		return wardrobeRepository.findByEmployeeId(id);
	}

}
