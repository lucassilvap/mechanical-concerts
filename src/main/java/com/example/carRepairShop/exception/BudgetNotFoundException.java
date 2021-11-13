package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BudgetNotFoundException extends ResponseStatusException{

	public BudgetNotFoundException() {
		super(HttpStatus.BAD_REQUEST, "budget not found !!");
		// TODO Auto-generated constructor stub
	}

}
