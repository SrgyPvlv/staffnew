package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DeviceTypeEntity;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceTypeEntity, Long> {

}
