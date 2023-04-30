package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.SertificateNameEntity;

@Repository
public interface SertificateNameRepository extends JpaRepository<SertificateNameEntity,Long> {

}
