package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationTest {

    private Station station;

    @BeforeEach
    public void setUp() {
        station = new Station("Huerna", "Asturias");
    }
    @Test
    @DisplayName("Test getName")
    public void getNameTest() {
        String name = station.getName();
        assert name.equals("Huerna");
    }
    @Test
    @DisplayName("Test getCity")
    public void getCityTest() {
        String city = station.getCity();
        assertThat(city, is("Asturias"));
    }

}
