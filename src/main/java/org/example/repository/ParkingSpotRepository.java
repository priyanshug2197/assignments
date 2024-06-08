package org.example.repository;

import org.example.model.ParkingSpot;
import org.example.model.SpotStatus;
import org.example.model.VehicleColor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {

    // this is my in memory ds to store the parking info,
    // this can be extended to connect to db from this repository class or use JPA decorator also
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    Integer size = 0;

    public void create(Integer size) {
        this.size = size;
    }

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        parkingSpot.setSpotId(parkingSpots.size());
        return parkingSpot;
    }

    public ParkingSpot leave(Integer id) {
        parkingSpots.get(id).setStatus(SpotStatus.AVAILABLE);
        return parkingSpots.get(id);
    }

    public boolean isFull() {
        if(parkingSpots.size() >= size) {
            return true;
        }
        return false;
    }
    // vehicle type can be taken as input to customise further
    public ParkingSpot findAvailableSpot() {

        for (ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot.getStatus() == SpotStatus.AVAILABLE){
                return parkingSpot;
            }
        }

        return null;
    }

    public Integer searchRegsitration(String registration) {
        for (int i = 0; i < size; i++) {
            if (parkingSpots.get(i).getVehicleParked().getRegistrationNumber().equals(registration)) {
                return i;
            }
        }
        return -1;
    }

    public void ShowStatus() {
        for (int i = 0; i < size; i++) {
            if (i < parkingSpots.size() && parkingSpots.get(i).getStatus() == SpotStatus.OCCUPIED){
                System.out.println("Slot "+(i+1)+" -> "+parkingSpots.get(i).getVehicleParked().getRegistrationNumber()+" Car parked");
            } else {
                System.out.println("Slot "+(i+1)+" -> Empty");
            }
        }
    }

    public void showVehicleOfColor(VehicleColor vehicleColor) {
        System.out.print("Car with "+vehicleColor.toString()+" Color : ");
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot.getVehicleParked().getVehicleColor() == vehicleColor){
                System.out.print(parkingSpot.getVehicleParked().getRegistrationNumber()+" ");
            }
        }
        System.out.println();
    }
}
