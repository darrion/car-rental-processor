package com.example.carrentalprocessor.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.example.carrentalprocessor.util.ErrorConstants;
import org.springframework.validation.annotation.Validated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Car {

    @NotNull(message = ErrorConstants.NULL_VIN_NUMBER) 
    String vin; 
    @NotNull(message = ErrorConstants.NULL_LICENSE_PLATE)
    String licensePlate; 
    @NotNull(message = ErrorConstants.NULL_MANUFACTURER)
    String manufacturer; 
    @NotNull(message = ErrorConstants.NULL_MODEL)
    String model; 
    @NotNull(message = ErrorConstants.NULL_REGISTRATION_DAY)
    String registrationDay;
    @NotNull(message = ErrorConstants.NULL_REGISTRATION_MONTH)
    String registrationMonth; 
    @NotNull(message = ErrorConstants.NULL_REGISTRATION_YEAR)
    String registrationYear;  
    @Min(value = 0, message = ErrorConstants.INVALID_MILEAGE) 
    String mileage; 
    @Min(value = 0, message = ErrorConstants.INVALID_OIL_MILEAGE) 
    String oilMileage; 
    @Min(value = 0, message = ErrorConstants.INVALID_MAINTENANCE_MILEAGE) 
    String maintenanceMileage; 
    @Min(value = 0, message = ErrorConstants.INVALID_FUEL_LEVEL) 
    String fuelLevel; 
    @Min(value = 2020, message = ErrorConstants.INVALID_CAR_MODEL_YEAR)
    String year; 
}
