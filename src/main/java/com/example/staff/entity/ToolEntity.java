package com.example.staff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tools")
public class ToolEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tooltype_id")
	private ToolTypeEntity toolType;
	
	@ManyToOne
	@JoinColumn(name="toolname_id")
	private ToolNameEntity toolName;
	
	private String toolNumber;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
	
	private String toolComment;
	
	private String toolAccounting;
	
	private String storePlace;
}
