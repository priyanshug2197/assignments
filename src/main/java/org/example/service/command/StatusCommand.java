package org.example.service.command;

import org.example.controller.ParkingLotController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusCommand implements Command {
    @Autowired
    ParkingLotController parkingLotController;

    @Override
    public void execute(String input) {
        parkingLotController.ShowStatus();
    }

    @Override
    public boolean matches(String input) {
        List<String> inputList = Arrays.stream(input.split(" ")).toList();

        if (inputList.size() == 1 && inputList.get(0).equals("STATUS")) {
            return true;
        }
        return false;
    }
}
