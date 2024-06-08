package org.example.controller;

import org.example.model.VehicleColor;
import org.example.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParkingLotController {

    @Autowired
    ParkingService parkingService;

    public void create(Integer size) {
        parkingService.create(size);
    }

    public void ShowStatus() {
        parkingService.ShowStatus();
    }

    public void showVehicleOfColor(VehicleColor vehicleColor) {
        parkingService.showVehicleOfColor(vehicleColor);
    }
}
