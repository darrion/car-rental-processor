package com.example;

import com.example.carrentalprocessor.repository.PermissionRepository;
import com.example.carrentalprocessor.service.UserService;
import com.example.carrentalprocessor.table.AppUser;
import com.example.carrentalprocessor.table.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication @Slf4j
public class CarRentalProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalProcessorApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, PermissionRepository permissionRepository) {

		return args -> {

			userService.saveUser(new AppUser(0L, "rickgrimes", "Rick Grimes", "pwd123", new ArrayList<>()));
			userService.saveUser(new AppUser(1L, "lorigrimes", "Lori Grimes", "pwd123", new ArrayList<>()));
			userService.saveUser(new AppUser(2L, "carlgrimes", "Carl Grimes", "pwd123", new ArrayList<>()));
			userService.saveUser(new AppUser(3L, "carolpel", "Carol Peletier", "pwd123", new ArrayList<>()));

			userService.addPermissionToUser("rickgrimes", "ADMIN");
			userService.addPermissionToUser("rickgrimes", "USER");
			userService.addPermissionToUser("lorigrimes", "USER");
			userService.addPermissionToUser("carlgrimes", "USER");
			userService.addPermissionToUser("carolpel", "SUPER_ADMIN");
		};
	}
}
