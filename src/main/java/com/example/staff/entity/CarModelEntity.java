package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="carmodels")
public class CarModelEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String carModel;
	
	@OneToMany(mappedBy="carModel",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<CarEntity> cars=new ArrayList<>();
	
	public void addCarEntity(CarEntity carEntity) {
		cars.add(carEntity);
		carEntity.setCarModel(this);
	}
	
	public void removeCarEntity(CarEntity carEntity) {
		cars.remove(carEntity);
		carEntity.setCarModel(null);
	}
	
}
