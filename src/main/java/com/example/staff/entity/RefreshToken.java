package com.example.staff.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refreshtoken")
public class RefreshToken {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

	  @OneToOne
	  @JoinColumn(name = "user_id", referencedColumnName = "id")
	  private Users user;

	  @Column(nullable = false, unique = true)
	  private String token;

	  @Column(nullable = false)
	  private Instant expiryDate;
}
