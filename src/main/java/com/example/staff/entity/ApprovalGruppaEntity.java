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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="approval_gruppas")
public class ApprovalGruppaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String approvalGruppa;
	
	@OneToMany(mappedBy="approvalGruppa", fetch=FetchType.LAZY,orphanRemoval=true)
	@JsonIgnore
	private List<SertificateEntity> sertificates=new ArrayList<>();
	
	public void addSertificateEntity(SertificateEntity sertificateEntity) {
		sertificates.add(sertificateEntity);
		sertificateEntity.setApprovalGruppa(this);
	}
	
	public void removeSertificateEntity(SertificateEntity sertificateEntity) {
		sertificates.remove(sertificateEntity);
		sertificateEntity.setApprovalGruppa(null);
	}
	
}
