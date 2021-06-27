package com.example.carrentalprocessor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.carrentalprocessor.service.CarRentalService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarRentalProcessorApplicationTests {

	@Autowired 
	CarRentalService carRentalService; 

	@Test
	void contextLoads() {
		assertNotNull(carRentalService); 
	}

}
