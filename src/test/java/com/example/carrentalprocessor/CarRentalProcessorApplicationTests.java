package com.example.carrentalprocessor;

import com.example.carrentalprocessor.service.CarRentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CarRentalProcessorApplicationTests {

	@Autowired 
	CarRentalService carRentalService; 

	@Test
	void contextLoads() {
		assertNotNull(carRentalService); 
	}

}
