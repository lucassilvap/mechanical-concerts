package com.example.carRepairShop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carRepairShop.entity.Budget;
import com.example.carRepairShop.service.BudgetService;

@RestController
@RequestMapping("budget")
public class BudgetController {

	@Autowired
	private BudgetService budgetService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(budgetService.findById(id));
	}
	
	@PostMapping("{idCar}")
	public ResponseEntity<?> save(@RequestBody Budget budget, 
	@PathVariable(name = "idCar") Long idCar){
		return ResponseEntity.ok(budgetService.save(budget, idCar));
	}
	
	@PutMapping("approved/{idBudget}")
	public ResponseEntity<?> updateStatus(@PathVariable(name = "idBudget") Long id){
		return ResponseEntity.ok(budgetService.updateStatus(id));
	}
	
	@PutMapping("finished/{idBudget}")
	public ResponseEntity<?> finished(@PathVariable (name = "idBudget") Long id){
		return ResponseEntity.ok(budgetService.finished(id));
	}
}
