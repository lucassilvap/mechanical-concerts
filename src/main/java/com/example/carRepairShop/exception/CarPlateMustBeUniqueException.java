package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CarPlateMustBeUniqueException extends ResponseStatusException{

	public CarPlateMustBeUniqueException() {
		super(HttpStatus.BAD_REQUEST, "plate must be unique!!");
		// TODO Auto-generated constructor stub
	}

}
