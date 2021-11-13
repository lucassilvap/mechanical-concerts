package com.example.carRepairShop.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAdress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomerAdress;
	
	private String number;
	
	private String road;
	
	private String cep;
	
	private String city;
	
	private String state;
	
	private String complement;
	
}
