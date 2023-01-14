package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="function_groups")
public class FunctionGroupEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String functionGroup;
	
	@OneToMany(mappedBy="functionGroup",fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<DepartmentEntity> departments=new ArrayList<>();
	
	public void addDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.add(departmentEntity);
		departmentEntity.setFunctionGroup(this);
	}
	
	public void removeDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.remove(departmentEntity);
		departmentEntity.setFunctionGroup(null);
	}
}
