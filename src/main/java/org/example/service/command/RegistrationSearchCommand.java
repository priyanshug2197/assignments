package org.example.service.command;

import org.example.controller.ParkingSpotController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegistrationSearchCommand implements Command{
    @Autowired
    ParkingSpotController parkingSpotController;
    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        String registration = inputList.get(1);
        Integer slot = parkingSpotController.searchRegsitration(registration);
        System.out.println("registration "+ registration + " parked at slot " + (slot+1));
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 2 && inputList.get(0).equals("REGISTRATION")) {
            return true;
        }
        return false;
    }
}
