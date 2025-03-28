package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.martabernardo.peaje.vehicle.Car;
import dev.martabernardo.peaje.vehicle.Vehicle;

@ExtendWith(MockitoExtension.class)
public class StationTest {
    @Mock
    private StationRepository stationRepository;

    private Station station;

    @Mock
    private Station mockStation;

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
    @Test
    @DisplayName("Test getVehicles")
    public void testGetVehiclesTest() {
        Vehicle vehicle = new Car("1234MNL");

        Station station = new Station("Guadarrama", "Madrid");
        station.getVehicles().add(vehicle);

        when(stationRepository.findById(1L)).thenReturn(Optional.of(station));

        Station result = stationRepository.findById(1L).orElseThrow();
        Set<Vehicle> vehicles = result.getVehicles();

        assertThat(vehicles, is(notNullValue()));
        assertThat(vehicles.size(), is(1));

        verify(stationRepository).findById(1L);
    }
    @Test
    @DisplayName("getId devuelve el ID asignado tras persistencia")
    void getIdTest() {  
        when(mockStation.getId()).thenReturn(1L);
        when(stationRepository.save(any())).thenReturn(mockStation);

        Station saved = stationRepository.save(new Station("Norte", "Oviedo"));

        assertThat(saved.getId(), is(1L));
    }
}
