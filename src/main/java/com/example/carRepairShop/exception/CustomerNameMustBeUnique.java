package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNameMustBeUnique extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNameMustBeUnique() {
		super(HttpStatus.BAD_GATEWAY, "customer name must be unique !!!");
	
	}
}
