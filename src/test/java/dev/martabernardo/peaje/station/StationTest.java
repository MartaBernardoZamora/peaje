package dev.martabernardo.peaje.station;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationTest {
    @Test
    @DisplayName("Test getName")
    public void getNameTest() {
        Station station = new Station("Huerna");
        String name = station.getName();
        assert name.equals("Huerna");
    }

}
