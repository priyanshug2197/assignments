package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class ParkingLot {

    private String name;
    private String address;

    List<ParkingFloor> parkingFloors = new ArrayList<>();
    List<EntryGate> entryGates = new ArrayList<>();
    List<ExitGate> exitGates = new ArrayList<>();

    // I am using builder pattern here as I have these many things and wish to minimise any error while setting them up

    public static Builder toBuilder() {
        return new Builder();
    }

    public static class Builder {
        private ParkingLot parkingLot;

        private Builder() {
            this.parkingLot = new ParkingLot();
        }

//        public Builder withFloors(int floors, int capacity) {
//            List<ParkingFloor> parkingFloors = Collections.nCopies(floors, new ParkingFloor());
//            for (int i = 0; i < floors; i++) {
//                ParkingFloor floor = parkingFloors.get(i);
//
//                floor.setFloorNo(i+1);
//
//                List<ParkingSpot> spots = Collections.nCopies(capacity, new ParkingSpot());
//                floor.setParkingSpots(spots);
//            }
//            parkingLot.setParkingFloors(parkingFloors);
//
//            return this;
//        }

        public ParkingLot build() {
            return parkingLot;
        }
    }

}
