package com.example.carRepairShop.service;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.carRepairShop.PageOptions.PageCreate;
import com.example.carRepairShop.Specification.CustomerSpecification;
import com.example.carRepairShop.entity.Customer;
import com.example.carRepairShop.exception.CustomerCpfMustBeUniqueException;
import com.example.carRepairShop.exception.CustomerNameMustBeUnique;
import com.example.carRepairShop.exception.CustomerNotFoundException;
import com.example.carRepairShop.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAdressService customerAdressService;
	
	@Autowired
	private CarService carService;
		
	public Customer findByName(Customer customer) {
		Optional<Customer> optionalCustomer = 
		customerRepository.findByNameContainingIgnoreCase(customer.getName());
	    return optionalCustomer.orElseThrow(CustomerNotFoundException::new);	
	}
		
	public Customer findById(Long id) {
		Optional<Customer> optionalCustomer =
		customerRepository.findById(id);
		return optionalCustomer.orElseThrow(CustomerNotFoundException::new);
	}
	
	public void validateCustomerNameIsUnique(String name) {
		if (customerRepository.
		findByNameContainingIgnoreCase(name).isPresent())
		throw new CustomerNameMustBeUnique();
	}
	
	public void validateCustomerCpfIsUnique(String cpf) {
	    if (customerRepository.findByCpf(cpf).isPresent())
	    throw new CustomerCpfMustBeUniqueException();
	}
	
    public  Customer saveCustomer(Customer customer) {
        validateCustomerNameIsUnique(customer.getName());
        customerAdressService.validateCustomerAdress(customer.getCustomerAdress());
        carService.validaSaveCar(customer.getCars());
        return customerRepository.save(customer);
    }
    
    public Page<Customer> findALLCustomer(Optional<String> name, Optional<String> cpf) {
    	return customerRepository.findAll(CustomerSpecification.spec(name, cpf),
    			new PageCreate().buid());
    }
 
}
