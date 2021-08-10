package com.example.carrentalprocessor.table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Table("cars")
public class Cars {
    @PrimaryKey @Id String vin; 
    private String licenseplate; 
    private String manufacturer; 
    private String model; 
    private LocalDate registrationdate; 
    private BigInteger mileage;
    private BigInteger oilmileage; 
    private BigInteger maintenancemileage; 
    private Integer fuellevel; 
    private Integer year; 
}
