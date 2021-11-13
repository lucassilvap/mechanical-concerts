package com.example.carRepairShop.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.carRepairShop.entity.Car;
import com.example.carRepairShop.exception.CarNotFoundException;
import com.example.carRepairShop.exception.CarPlateMustBeUniqueException;
import com.example.carRepairShop.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CustomerService customerService;
	
	public void validaSaveCar(List<Car> car) {
		car.forEach(carT -> validatePlateIsUnique(carT.getPlate()));
	}
	
	public void validatePlateIsUnique(String plate) {
		if (carRepository.findByPlate(plate).isPresent())
		throw new CarPlateMustBeUniqueException();
	}
	
	public Car findById(Long id) {
		return carRepository.findById(id).
		orElseThrow(CarNotFoundException::new);
	}
	
	public void saveCar(Car car) {
		carRepository.save(car);
	}
	
	public List<Car> findCarsByCostumer(Long idCustomer) {
	return carRepository
	.findByCustomer(customerService.findById(idCustomer))
	.orElseThrow(CarNotFoundException::new);
	}
		
}
