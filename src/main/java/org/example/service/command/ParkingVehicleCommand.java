package org.example.service.command;

import org.example.controller.ParkingSpotController;
import org.example.dto.ParkingSpotRequestDTO;
import org.example.dto.ParkingSpotResponseDTO;
import org.example.model.VehicleColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ParkingVehicleCommand implements Command{

    @Autowired
    ParkingSpotController parkingSpotController;
    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        String registration = inputList.get(1);
        String color = inputList.get(2);
        VehicleColor vehicleColor = VehicleColor.valueOf(color);
        ParkingSpotRequestDTO parkingSpotRequestDTO = new ParkingSpotRequestDTO();
        parkingSpotRequestDTO.setRegistrationNo(registration);
        parkingSpotRequestDTO.setColor(vehicleColor);
        ParkingSpotResponseDTO parkingSpotResponseDTO = parkingSpotController.park(parkingSpotRequestDTO);
        System.out.println("Parked at Slot "+parkingSpotResponseDTO.getParkingSpotId());
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 3 && inputList.get(0).equals("PARK")) {
            return true;
        }
        return false;
    }
}
