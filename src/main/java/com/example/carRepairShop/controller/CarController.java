package com.example.carRepairShop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.carRepairShop.service.CarService;


@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService carservice;
		
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(carservice.findById(id));
	}
	
	@GetMapping("/customer/{idCustomer}")
	public ResponseEntity<?> findByCostumer(@PathVariable(value = "idCustomer") Long id){
		return ResponseEntity.ok(carservice.findCarsByCostumer(id));
	}
}
