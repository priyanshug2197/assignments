package org.example.service;

import org.example.model.ParkingSpot;
import org.example.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot bookSlot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    public ParkingSpot leave(Integer spotId) {
        return parkingSpotRepository.leave(spotId);
    }
}
