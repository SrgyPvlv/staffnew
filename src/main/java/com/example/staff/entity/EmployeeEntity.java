package com.example.staff.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String mobilePhone;
	private LocalDate birthday;
	private Integer localPhone;
	private Integer employeeId;
	private String login;
	private String email;
	private String employeeComment;
	
	@ManyToOne
	@JoinColumn(name="fact_departments_id")
	private DepartmentEntity factDepartment;
	
	@ManyToOne
	@JoinColumn(name="staff_departments_id")
	private DepartmentEntity staffDepartment;
	
	@OneToOne
	@JoinColumn(name="cars_id")
	private CarEntity car;
	
	@ManyToOne
	@JoinColumn(name="positions_id")
	private PositionEntity position;
}
