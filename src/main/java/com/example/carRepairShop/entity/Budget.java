package com.example.carRepairShop.entity;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String mechanicName;
	
	@JsonIgnore
	private LocalDate entry;
	
	@JsonIgnore
	private LocalDate exit;
	
	private Boolean approved;
	
	private Boolean finish;
	
	@ManyToOne
	private Car car;
	
}
