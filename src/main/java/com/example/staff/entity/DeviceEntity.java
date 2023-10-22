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
@Table(name="devices")
public class DeviceEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="devicetype_id")
	private DeviceTypeEntity deviceType;
	
	@ManyToOne
	@JoinColumn(name="devicename_id")
	private DeviceNameEntity deviceName;
	
	private String deviceNumber;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private EmployeeEntity employee;
	
	private String deviceComment;
	
	private String deviceAccounting;
	
	private String storePlace;
	
	private boolean verificationNeed;
	
	private boolean inVerification;
	
	private LocalDate dateMoving;

}
