package com.example;

import com.example.carrentalprocessor.service.UserService;
import com.example.carrentalprocessor.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Random;

@SpringBootApplication
public class CarRentalProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalProcessorApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {

		return args -> {

			userService.saveUser(new User(0L, "rickgrimes", "Rick Grimes", "pwd123", null));
			userService.saveUser(new User(1L, "lorigrimes", "Lori Grimes", "pwd123", null));
			userService.saveUser(new User(2L, "carlgrimes", "Carl Grimes", "pwd123", null));
			userService.saveUser(new User(3L, "carolpel", "Carol Peletier", "pwd123", null));

			userService.addPermissionToUser("rickgrimes", "ADMIN");
			userService.addPermissionToUser("lorigrimes", "MANAGER");
			userService.addPermissionToUser("carlgrimes", "USER");
			userService.addPermissionToUser("carolpel", "SUPER_ADMIN");
		};
	}
}
