package com.example.carRepairShop.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.carRepairShop.entity.Customer;
import com.example.carRepairShop.service.CustomerService;


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.saveCustomer(customer));
	}
	
	@GetMapping("pageCustomer")
	public ResponseEntity<?> findBy(@RequestParam
	(required = true, value = "name")
	Optional<String> name,
	@RequestParam (required = true, value = "cpf") Optional<String> cpf){
	  return ResponseEntity.ok(customerService.findALLCustomer(name, cpf));	
	}
	
}
