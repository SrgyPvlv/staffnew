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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="departments")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="division_id")
	private DivisionEntity division;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private GroupeEntity groupe;
	
	@ManyToOne
	@JoinColumn(name="function_group_id")
	private FunctionGroupEntity functionGroup;
	
}
