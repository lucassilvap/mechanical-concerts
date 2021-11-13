package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BudgetAlreadyExistException extends ResponseStatusException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BudgetAlreadyExistException() {
		super(HttpStatus.BAD_GATEWAY,  "budget already exists!!");
	}
}
