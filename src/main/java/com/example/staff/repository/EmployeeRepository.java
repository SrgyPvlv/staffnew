package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.staff.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
	
	List<EmployeeEntity> findByNameIgnoreCaseContainingOrderByNameAsc(@Param("filter") String filter);
	
	List<EmployeeEntity> findByMobilePhoneContainingOrderByNameAsc(@Param("filter") String filter);
	
	List<EmployeeEntity> findByPositionPositionIgnoreCaseContainingOrderByNameAsc(@Param("filter") String filter);
	
	List<EmployeeEntity> findByFactDepartmentDivisionDivisionOrFactDepartmentGroupeGroupeOrFactDepartmentFunctionGroupFunctionGroupOrderByNameAsc(@Param("filter1") String filter1,@Param("filter2") String filter2,@Param("filter3") String filter3);
	
	List<EmployeeEntity> findByStaffDepartmentDivisionDivisionOrStaffDepartmentGroupeGroupeOrStaffDepartmentFunctionGroupFunctionGroupOrderByNameAsc(@Param("filter1") String filter1,@Param("filter2") String filter2,@Param("filter3") String filter3);
	
}
