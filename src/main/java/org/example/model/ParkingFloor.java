package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParkingFloor {

    private Integer floorNo;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
}
