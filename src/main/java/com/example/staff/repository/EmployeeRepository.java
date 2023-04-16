package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
		
	List<EmployeeEntity> findByNameIgnoreCaseContainingOrMobilePhoneIgnoreCaseContainingOrPositionPositionIgnoreCaseContainingOrderByNameAsc(String filter1,String filter2,String filter3);
	
	List<EmployeeEntity> findByFactDepartmentDivisionDivisionOrFactDepartmentGroupeGroupeOrFactDepartmentFunctionGroupFunctionGroupOrderByNameAsc(String filter1,String filter2,String filter3);
	
	List<EmployeeEntity> findByStaffDepartmentDivisionDivisionOrStaffDepartmentGroupeGroupeOrStaffDepartmentFunctionGroupFunctionGroupOrderByNameAsc(String filter1,String filter2,String filter3);
	
	List<EmployeeEntity> findByFactDepartmentDivisionDivisionInOrFactDepartmentGroupeGroupeInOrFactDepartmentFunctionGroupFunctionGroupInOrPositionPositionIn(List<String> filter1,List<String> filter2,List<String> filter3,List<String> filter4);
	
}
