package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.DeviceNameEntity;

@Repository
public interface DeviceNameRepository extends JpaRepository<DeviceNameEntity,Long> {

}
