package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.SertificateEntity;

@Repository
public interface SertificateRepository extends JpaRepository<SertificateEntity,Long> {

	List<SertificateEntity> findByEmployeeId(Long id);
}
