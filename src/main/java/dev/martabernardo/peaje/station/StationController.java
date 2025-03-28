package dev.martabernardo.peaje.station;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;

@RestController
public class StationController{

    private StationService stationService;
    private StationView stationView;

    public StationController(StationService stationService, StationView stationView) {
        this.stationService = stationService;
        this.stationView = stationView;
    }

    public void getStationData(long stationId) {
        stationService.getVehicleList(stationId);
    }

    public int getTotalPayment(long stationId) {
        return stationService.getTotalPayment(stationId);
    }

    public void index() {
        List<Station> stations = stationService.getAllStations();
        stations.forEach(s -> s.getVehicles().size());
        
        System.out.println("INFO PEAJES");
        for (Station station : stations) {
            stationView.printStation(station);
            long stationId = station.getId();       
            List<VehicleDTOSummary> vehicles = stationService.getVehicleList(stationId);
            stationView.printVehicles(vehicles);
            int totalPayment = stationService.getTotalPayment(stationId);
            stationView.printTotalPayment(totalPayment);
        }
    }
}
