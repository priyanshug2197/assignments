package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpot {

    private Integer spotId;
    private Integer floor;
    private Vehicle vehicleParked;
    private SpotStatus status;
}
