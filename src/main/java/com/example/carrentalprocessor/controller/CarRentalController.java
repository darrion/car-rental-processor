package com.example.carrentalprocessor.controller;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.example.carrentalprocessor.model.Car;
import com.example.carrentalprocessor.service.CarRentalService;
import com.example.carrentalprocessor.util.ErrorConstants;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
public class CarRentalController {

    @Autowired
    CarRentalService carRentalService;
    
    @PostMapping("/car")
    public ResponseEntity<Object> addCar
    (
        @Valid @RequestBody Car car
    ) 
    {
        return ResponseEntity.ok(car); 
    }

    @GetMapping("/car")
    public ResponseEntity<Object> getCar
    (
        @RequestParam("vin") 
        @Length(min = 15, max = 15, message = ErrorConstants.INVALID_LENGTH_VIN_NUMBER) 
        String vin
    ) 
    {
        Car car = carRentalService.getCar(vin); 
        return ResponseEntity.ok(car); 
    }
}
