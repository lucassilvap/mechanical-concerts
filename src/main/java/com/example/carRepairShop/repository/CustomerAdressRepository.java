package com.example.carRepairShop.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carRepairShop.entity.CustomerAdress;

@Repository
public interface CustomerAdressRepository extends CrudRepository<CustomerAdress, Long> {

	Optional<CustomerAdress> findByCep(String cep);
}
