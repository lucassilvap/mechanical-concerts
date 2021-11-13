package com.example.carRepairShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CepMustBeUniqueException extends ResponseStatusException{

	public CepMustBeUniqueException() {
		super(HttpStatus.BAD_GATEWAY, "cep must be unique !!");
		// TODO Auto-generated constructor stub
	}

}
