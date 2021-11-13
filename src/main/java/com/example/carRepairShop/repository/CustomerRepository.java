package com.example.carRepairShop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carRepairShop.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> , JpaSpecificationExecutor<Customer>{

	 Optional<Customer> findByNameContainingIgnoreCase(String name);
	 
	 Optional<Customer> findByCpf(String cpf);
}
