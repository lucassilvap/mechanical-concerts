package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerCpfMustBeUniqueException extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerCpfMustBeUniqueException() {
		super(HttpStatus.BAD_REQUEST, "Customer cpf must be unique!");
		// TODO Auto-generated constructor stub
	}

}
