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
@Table(name="positions")
public class PositionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String position;
	
	
	@OneToMany(mappedBy="position",fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<EmployeeEntity> employees=new ArrayList<>();
	
	public void addEmployeeEntity(EmployeeEntity employeeEntity) {
		employees.add(employeeEntity);
		employeeEntity.setPosition(this);
	}
	
	public void removeEmployeeEntity(EmployeeEntity employeeEntity) {
		employees.remove(employeeEntity);
		employeeEntity.setPosition(null);
	}
	
}
