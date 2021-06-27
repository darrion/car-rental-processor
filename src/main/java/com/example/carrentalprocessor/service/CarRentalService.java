package com.example.carrentalprocessor.service;

import com.example.carrentalprocessor.model.Car;

import org.springframework.stereotype.Service;

@Service
public class CarRentalService {
    
    public Car getCar(String vin) {
        return new Car();
    }
}
