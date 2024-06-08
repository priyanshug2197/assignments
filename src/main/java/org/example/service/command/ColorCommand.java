package org.example.service.command;

import org.example.controller.ParkingLotController;
import org.example.model.VehicleColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ColorCommand implements Command{
    @Autowired
    ParkingLotController parkingLotController;
    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        String color = inputList.get(1);
        VehicleColor vehicleColor = VehicleColor.valueOf(color);
        parkingLotController.showVehicleOfColor(vehicleColor);
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 2 && inputList.get(0).equals("COLOR")) {
            return true;
        }
        return false;
    }
}
