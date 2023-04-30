package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.staff.entity.ApprovalGruppaEntity;
import com.example.staff.exception.ItemNotFoundException;
import com.example.staff.repository.ApprovalGruppaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultApprovalGruppaEntityService implements ApprovalGruppaEntityService {
	
	private final ApprovalGruppaRepository approvalGruppaRepository;

	@Override
	public ApprovalGruppaEntity getApprovalGruppaEntityById(Long id) {
		
		ApprovalGruppaEntity approvalGruppa=approvalGruppaRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("ApprovalGruppa not found: id = "+ id));
		return approvalGruppa;
	}

	@Override
	public List<ApprovalGruppaEntity> getAllApprovalGruppaEntity() {
		
		return approvalGruppaRepository.findAll();
	}

	@Override
	public ApprovalGruppaEntity addApprovalGruppaEntity(ApprovalGruppaEntity approvalGruppa) {
		
		return approvalGruppaRepository.saveAndFlush(approvalGruppa);
	}

	@Override
	public ApprovalGruppaEntity editApprovalGruppaEntity(Long id, ApprovalGruppaEntity approvalGruppa) {
		
		ApprovalGruppaEntity editedApprovalGruppa=approvalGruppaRepository
				.findById(id)
				.orElseThrow(()->new ItemNotFoundException("ApprovalGruppa not found: id = "+ id));
		editedApprovalGruppa.setApprovalGruppa(approvalGruppa.getApprovalGruppa());
		
		return approvalGruppaRepository.saveAndFlush(editedApprovalGruppa);
	}

	@Override
	public void deleteApprovalGruppaEntityById(Long id) {
		
		approvalGruppaRepository.deleteById(id);		
	}

}
