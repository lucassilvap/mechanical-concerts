package com.example.carRepairShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.*")
@ComponentScan("com.*")
public class CarRepairShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRepairShopApplication.class, args);
	}

}
