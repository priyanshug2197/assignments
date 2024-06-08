package org.example.service;

import org.example.dto.ParkingSpotRequestDTO;
import org.example.dto.ParkingSpotResponseDTO;
import org.example.model.ParkingSpot;
import org.example.model.SpotStatus;
import org.example.model.Vehicle;
import org.example.model.VehicleColor;
import org.example.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    ParkingSpotService parkingSpotService;
    @Autowired
    SpotAllocationService allocationService;
    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    public Integer park(String registration, VehicleColor vehicleColor) {

        ParkingSpot parkingSpot = allocationService.allocateSlot();
        ParkingSpot parkingSpotAfterParking = null;
        if (parkingSpot == null && parkingSpotRepository.isFull()) {
            throw new RuntimeException("Slot not available!");
        } else if (parkingSpot == null) {
            Vehicle vehicle = Vehicle.builder().
                    registrationNumber(registration).
                    vehicleColor(vehicleColor).build();
            parkingSpot = ParkingSpot.builder().vehicleParked(vehicle).status(SpotStatus.OCCUPIED).build();

            parkingSpotAfterParking = parkingSpotService.bookSlot(parkingSpot);
        } else {
            parkingSpot.getVehicleParked().setRegistrationNumber(registration);
            parkingSpot.getVehicleParked().setVehicleColor(vehicleColor);
            parkingSpot.setStatus(SpotStatus.OCCUPIED);
        }

        ParkingSpotResponseDTO parkingSpotResponseDTO = new ParkingSpotResponseDTO();
        if (parkingSpotAfterParking != null) {
            parkingSpotResponseDTO.setParkingSpotId(parkingSpotAfterParking.getSpotId());
        } else {
            parkingSpotResponseDTO.setParkingSpotId(parkingSpot.getSpotId());
        }
        return parkingSpotResponseDTO.getParkingSpotId();
    }

    public String leave(Integer spotId) {
        return parkingSpotService.leave(spotId).getVehicleParked().getRegistrationNumber();
    }

    public void create(Integer size) {
        parkingSpotRepository.create(size);
    }

    public Integer searchRegsitration(String registation) {
        return parkingSpotRepository.searchRegsitration(registation);
    }

    public void ShowStatus() {
        parkingSpotRepository.ShowStatus();
    }

    public void showVehicleOfColor(VehicleColor vehicleColor) {
        parkingSpotRepository.showVehicleOfColor(vehicleColor);
    }
}
