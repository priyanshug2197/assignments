package org.example;

import org.example.service.command.ColorCommand;
import org.example.service.command.CreateParkingLotCommand;
import org.example.service.command.LeaveVehicleCommand;
import org.example.service.command.ParkingVehicleCommand;
import org.example.service.command.RegistrationSearchCommand;
import org.example.service.command.StatusCommand;
import org.example.service.registry.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private ColorCommand colorCommand;
    @Autowired
    private CreateParkingLotCommand createParkingLotCommand;
    @Autowired
    private LeaveVehicleCommand leaveVehicleCommand;
    @Autowired
    private ParkingVehicleCommand parkingVehicleCommand;
    @Autowired
    private RegistrationSearchCommand registrationSearchCommand;
    @Autowired
    private StatusCommand statusCommand;

    @Autowired
    private CommandRegistry commandRegistry;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        commandRegistry.RegisterCommand(colorCommand);
        commandRegistry.RegisterCommand(createParkingLotCommand);
        commandRegistry.RegisterCommand(leaveVehicleCommand);
        commandRegistry.RegisterCommand(parkingVehicleCommand);
        commandRegistry.RegisterCommand(registrationSearchCommand);
        commandRegistry.RegisterCommand(statusCommand);

        String input = "CREATE lot 5";
        commandRegistry.executeCommand(input);

        String input1 = "PARK KA01AB1234 White";
        commandRegistry.executeCommand(input1);

        String input2 = "PARK KA03DE3434 Blue";
        commandRegistry.executeCommand(input2);

        String input3 = "PARK KA04BC6734 White";
        commandRegistry.executeCommand(input3);

        String input4 = "LEAVE slot 2";
        commandRegistry.executeCommand(input4);

        String input5 = "PARK KA05VB4567 Yellow";
        commandRegistry.executeCommand(input5);

        String input6 = "STATUS";
        commandRegistry.executeCommand(input6);

        String input7 = "COLOR White";
        commandRegistry.executeCommand(input7);

        String input8 = "REGISTRATION KA04BC6734";
        commandRegistry.executeCommand(input8);

        // I need a place where I can register the command
        // and that allows me to parse the command to find the correct command out of the ones that are registered.
    }
}


/*
functional
create lot 5 (capacity)
    parking lot created
park KA01AB1234 White
    Parked at slot 1
park KA03DE3434 Blue
    Parked at slot 2
park KA04BC6734 White
    Parked at slot 3
leave Slot 2
    Leave KA04BC6734
park KA05VB4567 Yellow
    Parked at slot 2
status
     Slot 1 -> KA01AB1234 Car parked
     Slot 2 -> KA05VB4567 Car parked
     Slot 3 -> KA04BC6734 Car parked
     Slot 4 -> Empty
     Slot 5 -> Empty
color White
    Car with White Color : KA01AB1234, KA04BC6734 (order agnostic)
registration KA04BC6734
    registration KA04BC6734 parked at slot 3

* Extensive to inclusive of other types of vehicle
* Extensive to inclusive of other like parking stratergy (farthest)
* Input Validation (DTO validator)
* I/O from CLI
* Parking lot is full
* leave slot abc - Invalidate in Validator | Slot number is not present | Slot number not provided
* Parking size is fixed
* In-memory database ( should be extensible)
* Duplicate registration not allowed



Questions:
*
 */