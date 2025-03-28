package dev.martabernardo.peaje.station;

import java.util.Set;

import dev.martabernardo.peaje.vehicle.Vehicle;

public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Set<Vehicle> getVehicleList(long l) {

        return stationRepository.findById(l).orElseThrow().getVehicles();

    }
    

}
