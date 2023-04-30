package com.example.staff.entity;

import java.time.LocalDate;

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
@Table(name="sertificates")
public class SertificateEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sertificatename_id")
	private SertificateNameEntity sertificateName;
	
	private String sertificateNumber;
	
	@ManyToOne
	@JoinColumn(name="approvalgruppa_id")
	private ApprovalGruppaEntity approvalGruppa;
	
	private LocalDate issueDate;
	
	private LocalDate expirationDate;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
}
