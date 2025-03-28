package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;

public class StationViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Test
    @DisplayName("Test printStation imprime correctamente nombre y ciudad")
    void printStationTest() {
        StationView view = new StationView();
        System.setOut(new PrintStream(outContent));
        view.printStation(new Station("Norte", "Oviedo"));

        String output = outContent.toString();

        assertThat(output, containsString("Norte"));
        assertThat(output, containsString("Oviedo"));
        System.setOut(originalOut);
    }
    @Test
    @DisplayName("Test printVehicles")
    void printVehiclesTest() { 
        StationView view = new StationView();
        System.setOut(new PrintStream(outContent));
        view.printVehicles(List.of(new VehicleDTOSummary("CAR001", 100, "Car")));
        String output = outContent.toString();
        assertThat(output, containsString("CAR001"));
        assertThat(output, containsString("100"));
        assertThat(output, containsString("Car"));
        System.setOut(originalOut);
    }
}
