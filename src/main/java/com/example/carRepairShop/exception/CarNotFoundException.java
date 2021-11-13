package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CarNotFoundException extends ResponseStatusException{

	public CarNotFoundException() {
		super(HttpStatus.BAD_REQUEST, "car not found !!");
		// TODO Auto-generated constructor stub
	}

}
