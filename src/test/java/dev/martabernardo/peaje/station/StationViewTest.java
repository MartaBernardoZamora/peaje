package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
