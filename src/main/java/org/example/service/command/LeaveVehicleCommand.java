package org.example.service.command;

import org.example.controller.ParkingSpotController;
import org.example.dto.LeaveSpotRequestDTO;
import org.example.dto.LeaveSpotResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LeaveVehicleCommand implements Command{
    @Autowired
    ParkingSpotController parkingSpotController;

    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        Integer spotId = Integer.valueOf(inputList.get(2)) - 1;
        LeaveSpotRequestDTO leaveSpotRequestDTO = new LeaveSpotRequestDTO();
        leaveSpotRequestDTO.setId(spotId);
        LeaveSpotResponseDTO leaveSpotResponseDTO = parkingSpotController.leave(leaveSpotRequestDTO);

        //System.out.println("Leave "+leaveSpotResponseDTO.getRegistration());
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 3 && inputList.get(0).equals("LEAVE")) {
            return true;
        }
        return false;
    }
}
