package com.example.carRepairShop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carRepairShop.entity.Car;
import com.example.carRepairShop.entity.Customer;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

	 Optional<Car> findByPlate(String plate);
	 
	 Optional<List<Car>> findByCustomer(Customer customer);
}
