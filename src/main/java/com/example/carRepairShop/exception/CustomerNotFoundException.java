package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super(HttpStatus.NOT_FOUND, "customer not found !!");
		// TODO Auto-generated constructor stub
	}

}
