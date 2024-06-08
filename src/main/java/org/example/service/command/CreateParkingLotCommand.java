package org.example.service.command;

import org.example.controller.ParkingLotController;
import org.example.controller.ParkingSpotController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CreateParkingLotCommand implements Command{

    @Autowired
    ParkingLotController parkingLotController;

    @Override
    public void execute(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();
        Integer size = Integer.valueOf(inputList.get(2));
        parkingLotController.create(size);
        System.out.println("Parking lot created");
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 3 && inputList.get(0).equals("CREATE")) {
            return true;
        }
        return false;
    }
}
