package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.SertificateEntity;

@Repository
public interface SertificateRepository extends JpaRepository<SertificateEntity,Long> {

}
