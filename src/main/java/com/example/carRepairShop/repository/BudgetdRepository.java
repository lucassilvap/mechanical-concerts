package com.example.carRepairShop.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carRepairShop.entity.Budget;
import com.example.carRepairShop.entity.Car;

@Repository
public interface BudgetdRepository extends CrudRepository<Budget, Long>{
   
	Optional<Budget> findByCar(Car car);
	
	Optional<Budget> findByMechanicName(String mechanicName);
	
	Optional<Budget> findByEntry(LocalDate localDate);
	
}
