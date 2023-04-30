package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.ApprovalGruppaEntity;

public interface ApprovalGruppaEntityService {

	ApprovalGruppaEntity getApprovalGruppaEntityById(Long id);
	List<ApprovalGruppaEntity> getAllApprovalGruppaEntity();
	ApprovalGruppaEntity addApprovalGruppaEntity(ApprovalGruppaEntity approvalGruppa);
	ApprovalGruppaEntity editApprovalGruppaEntity(Long id, ApprovalGruppaEntity approvalGruppa);
	void deleteApprovalGruppaEntityById(Long id);
}
