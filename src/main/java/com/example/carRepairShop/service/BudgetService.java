package com.example.carRepairShop.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carRepairShop.entity.Budget;
import com.example.carRepairShop.entity.Car;
import com.example.carRepairShop.exception.BudgetAlreadyExistException;
import com.example.carRepairShop.exception.BudgetNotFoundException;
import com.example.carRepairShop.repository.BudgetdRepository;

@Service
public class BudgetService {

	@Autowired
	private BudgetdRepository budgetdRepository;
	
	@Autowired
	private CarService carService;
	
	public Budget save(Budget budget, Long idCar) {
       validateBudet(budget, idCar);
       Car car = carService.findById(idCar);
       budget.setCar(car);
       budget.setApproved(false);
       budget.setEntry(LocalDate.now());
       return budgetdRepository.save(budget);
	}
	
	private void validateBudet(Budget budget, Long idCar) {
      Boolean isNotValid = budgetdRepository.findById(idCar).isPresent() 
      && budgetdRepository.findByMechanicName(budget.getMechanicName())
      .isPresent()
      && budgetdRepository.findByEntry(budget.getEntry()).isPresent(); 
      if (isNotValid) throw new BudgetAlreadyExistException();
	}

	public Budget updateStatus(Long id) {
		Budget budget = findById(id);
		budget.setApproved(!budget.getApproved()); 
		return budgetdRepository.save(budget);
	}
	
	public Budget finished(Long id) {
		Budget budget = findById(id);
		budget.setFinish(true);
		return budgetdRepository.save(budget);
	}
	
	public Budget findById(Long id) {
		return budgetdRepository.findById(id).
		orElseThrow(BudgetNotFoundException::new);
	}
}
