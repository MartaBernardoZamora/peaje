package dev.martabernardo.peaje.station;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {

    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    public void getStationData(long stationId) {
        stationService.getVehicleList(stationId);
    }

    public int getTotalPayment(long stationId) {
        return stationService.getTotalPayment(stationId);
    }
}
