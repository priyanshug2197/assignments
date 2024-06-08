package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.model.VehicleColor;

@Getter
@Setter
public class ParkingSpotRequestDTO {
    private String registrationNo;
    private VehicleColor color;
}
