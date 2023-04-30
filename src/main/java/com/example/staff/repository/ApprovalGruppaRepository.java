package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.ApprovalGruppaEntity;

@Repository
public interface ApprovalGruppaRepository extends JpaRepository<ApprovalGruppaEntity,Long> {

}
