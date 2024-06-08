package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {

    private String registrationNumber;
    private VehicleColor vehicleColor;
    // can include vehicle type to move to pay system based on the vehicle type
}
