package dev.martabernardo.peaje;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.martabernardo.peaje.station.StationController;

@Component
public class AppRunner implements CommandLineRunner {

    private final StationController stationController;

    public AppRunner(StationController stationController) {
        this.stationController = stationController;
    }

    @Override
    public void run(String... args) throws Exception {
        stationController.index();
    }
}


