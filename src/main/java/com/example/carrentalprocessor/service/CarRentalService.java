package com.example.carrentalprocessor.service;

import com.example.carrentalprocessor.factory.CarFactory;
import com.example.carrentalprocessor.model.Car;
import com.example.carrentalprocessor.repository.CarRepository;
import com.example.carrentalprocessor.table.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class CarRentalService {

    @Autowired
    CarRepository carRepository; 

    public void saveCar(Car car) {
        Cars carTable;
        try {
            carTable = CarFactory.convert(car);
            carRepository.save(carTable); 
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }
    
    public Car getCarByVin(String vin) {
        return new Car();
    }
}
