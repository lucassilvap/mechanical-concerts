package com.example.carRepairShop.Specification;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.example.carRepairShop.entity.Customer;

public abstract class CustomerSpecification {

   private static Specification<Customer> byName(String name){
	return (root, cq, cb) -> cb.equal(root.get("name"), name);  
   }
   
   private static Specification<Customer> byCpf(String cpf){
	   return (root, cq, cb) -> cb.equal(root.get("cpf"), cpf);
   }
  
  public static Specification<Customer> spec(Optional<String> name,
       Optional<String> cpf){
	   Specification<Customer> spec = null;
	  
	   if(name.isPresent())
	   spec = byName(name.get()); 
	   if(cpf.isPresent()) spec = spec.and(byCpf(cpf.get()));
	   return spec;
  }
  
}
