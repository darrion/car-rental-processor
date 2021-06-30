package com.example.carrentalprocessor.service;

import com.example.carrentalprocessor.table.Cars;

import java.text.ParseException;

import com.example.carrentalprocessor.factory.CarFactory;
import com.example.carrentalprocessor.model.Car;
import com.example.carrentalprocessor.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRentalService {

    @Autowired
    CarRepository carRepository; 

    public void postCar(Car car) {
        Cars carTable;
        try {
            carTable = CarFactory.convert(car);
            carRepository.save(carTable); 
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }
    
    public Car getCar(String vin) {
        return new Car();
    }
}
