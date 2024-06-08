package org.example.controller;

import org.example.dto.LeaveSpotRequestDTO;
import org.example.dto.LeaveSpotResponseDTO;
import org.example.dto.ParkingSpotRequestDTO;
import org.example.dto.ParkingSpotResponseDTO;
import org.example.service.ParkingService;
import org.example.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParkingSpotController {

    @Autowired
    ParkingService parkingService;

    public ParkingSpotResponseDTO park(ParkingSpotRequestDTO parkingSpotRequestDTO) {
        Integer id = parkingService.park(parkingSpotRequestDTO.getRegistrationNo(), parkingSpotRequestDTO.getColor());
        ParkingSpotResponseDTO parkingSpotResponseDTO = new ParkingSpotResponseDTO();
        parkingSpotResponseDTO.setParkingSpotId(id);
        return parkingSpotResponseDTO;
    }

    public LeaveSpotResponseDTO leave(LeaveSpotRequestDTO leaveSpotRequestDTO) {
        Integer id = leaveSpotRequestDTO.getId();
        LeaveSpotResponseDTO leaveSpotResponseDTO = new LeaveSpotResponseDTO();
        leaveSpotResponseDTO.setRegistration(parkingService.leave(id));
        System.out.println("Leave " + leaveSpotResponseDTO.getRegistration());
        return leaveSpotResponseDTO;
    }

    public Integer searchRegsitration(String registration) {
        return parkingService.searchRegsitration(registration);
    }
}
