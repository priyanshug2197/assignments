package org.example.service;

import org.example.model.ParkingSpot;
import org.example.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotAllocationService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot allocateSlot() {
        return parkingSpotRepository.findAvailableSpot();
    }
}
