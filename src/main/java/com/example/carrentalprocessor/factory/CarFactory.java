package com.example.carrentalprocessor.factory;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CarFactory {
    public static com.example.carrentalprocessor.table.Cars convert(com.example.carrentalprocessor.model.Car carModel) throws ParseException {
        com.example.carrentalprocessor.table.Cars carTable = new com.example.carrentalprocessor.table.Cars();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
        Date date = simpleDateFormat.parse(
            carModel.getRegistrationYear() 
        + "-" + carModel.getRegistrationMonth() 
        + "-" + carModel.getRegistrationDay()); 
    
        carTable.setVin(carModel.getVin());
        carTable.setLicenseplate(carModel.getLicensePlate());
        carTable.setManufacturer(carModel.getManufacturer());
        carTable.setModel(carModel.getModel()); 
        carTable.setRegistrationdate(LocalDate.parse("2020-01-01"));
        carTable.setMileage(BigInteger.valueOf(Integer.parseInt(carModel.getMileage())));
        carTable.setOilmileage(BigInteger.valueOf(Integer.parseInt(carModel.getOilMileage())));
        carTable.setMaintenancemileage(BigInteger.valueOf(Integer.parseInt(carModel.getMaintenanceMileage())));
        carTable.setFuellevel(Integer.parseInt(carModel.getFuelLevel()));
        carTable.setYear(Integer.parseInt(carModel.getYear()));
        return carTable; 
    }
}
