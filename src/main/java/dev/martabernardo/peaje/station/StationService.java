package dev.martabernardo.peaje.station;

import java.util.List;
import java.util.stream.Collectors;

import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;

import org.springframework.stereotype.Service;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public List<VehicleDTOSummary> getVehicleList(long stationId){

        return stationRepository.findById(stationId)
            .orElseThrow()
            .getVehicles()
            .stream()
            .map(VehicleDTOSummary::from)
            .collect(Collectors.toList());

    }

    public int getTotalPayment(long stationId){
        List<VehicleDTOSummary> vehicles = getVehicleList(stationId);
        return vehicles.stream()
            .mapToInt(VehicleDTOSummary::payment)
            .sum();
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }   

}
