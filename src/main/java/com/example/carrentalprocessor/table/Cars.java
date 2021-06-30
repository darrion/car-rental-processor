package com.example.carrentalprocessor.table; 

import java.math.BigInteger;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

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
