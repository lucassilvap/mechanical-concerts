package com.example.carRepairShop.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carRepairShop.entity.CustomerAdress;
import com.example.carRepairShop.exception.CepMustBeUniqueException;
import com.example.carRepairShop.repository.CustomerAdressRepository;



@Service
public class CustomerAdressService {

	
	@Autowired
	private CustomerAdressRepository adressRepository;
	
	public void validateCustomerAdress(List<CustomerAdress> customerAdress) {
	   customerAdress.forEach(adress -> validateCepCustomerAdress(adress.getCep()));	
	}
	
	public void validateCepCustomerAdress(String cep) {
	  if(adressRepository.findByCep(cep).isPresent())
	  throw new CepMustBeUniqueException();
	}

}
