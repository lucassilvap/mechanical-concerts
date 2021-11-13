package com.example.carRepairShop.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomer;
	
	private String name;
	
	private String phoneNumber;
	
	private String cpf;
	
	private String rg;
	
	@OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<Car> cars = new ArrayList<Car>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerAdress> customerAdress =
	new ArrayList<CustomerAdress>();
	
	@PostPersist
	public void update() {
		cars.forEach(car -> car.setCustomer(this));
	}
		
}
