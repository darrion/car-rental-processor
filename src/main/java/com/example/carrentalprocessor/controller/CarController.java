package com.example.carrentalprocessor.controller;

import com.example.carrentalprocessor.model.Car;
import com.example.carrentalprocessor.service.CarRentalService;
import com.example.carrentalprocessor.util.ErrorConstants;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController("/api")
public class CarController {

    @Autowired
    private CarRentalService carRentalService;

    @PostMapping("/car/save")
    public ResponseEntity<Object> addCar
    (
        @Valid @RequestBody Car car
    ) 
    {
        carRentalService.saveCar(car);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/car/vin")
    public ResponseEntity<Object> getCar
    (
        @RequestParam("vin") 
        @Length(min = 15, max = 15, message = ErrorConstants.INVALID_LENGTH_VIN_NUMBER) 
        String vin
    ) 
    {
        Car car = carRentalService.getCarByVin(vin);
        return ResponseEntity.ok(car); 
    }
}
