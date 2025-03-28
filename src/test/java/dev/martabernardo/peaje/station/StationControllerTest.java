package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;


import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;
@ExtendWith(MockitoExtension.class)
public class StationControllerTest {

    @Mock
    StationService service;

    @Mock
    StationView view;


    @Test
    @DisplayName("Test getStationData")
    void getStationDataTest(){

        StationController stationController = new StationController(service, view);
        List<VehicleDTOSummary> vehicles = List.of(new VehicleDTOSummary("CAR001", 100, "Car"),
            new VehicleDTOSummary("MOTO001", 50, "Moto"),
            new VehicleDTOSummary("TRK001", 150, "Truck"));

        when(service.getVehicleList(1L)).thenReturn(vehicles);

        stationController.getStationData(1L);

        assertThat(vehicles, notNullValue());
        assertThat(vehicles, hasSize(3));
        assertThat(vehicles, containsInAnyOrder(
            new VehicleDTOSummary("CAR001", 100, "Car"),
            new VehicleDTOSummary("MOTO001", 50, "Moto"),
            new VehicleDTOSummary("TRK001", 150, "Truck")
        ));
    }
    @Test
    @DisplayName("Test getTotalPayment")
    void getTotalPaymentTest(){

        StationController stationController = new StationController(service, view);

        when(service.getTotalPayment(1L)).thenReturn(300);

        int totalPayment = stationController.getTotalPayment(1L);
        assertThat(totalPayment, is(300));
    }
    @Test
    @DisplayName("test full report from index ")
    void indexTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        StationController stationController = new StationController(service, view);
        Station station1 = new Station("Norte", "Oviedo");
        Station station2 = new Station("Sur", "Sevilla");

        List<Station> stations = List.of(station1, station2);

        List<VehicleDTOSummary> vehicles1 = List.of(
            new VehicleDTOSummary("CAR001", 100, "Car")
        );

        List<VehicleDTOSummary> vehicles2 = List.of(
            new VehicleDTOSummary("TRK002", 200, "Truck")
        );

        when(service.getAllStations()).thenReturn(stations);
        when(service.getVehicleList(1L)).thenReturn(vehicles1);
        when(service.getVehicleList(2L)).thenReturn(vehicles2);
        when(service.getTotalPayment(1L)).thenReturn(100);
        when(service.getTotalPayment(2L)).thenReturn(200);
        Field field = Station.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(station1, 1L);
        field.set(station2, 2L);

        stationController.index();

        verify(view).printStation(station1);
        verify(view).printVehicles(vehicles1);
        verify(view).printTotalPayment(100);

        verify(view).printStation(station2);
        verify(view).printVehicles(vehicles2);
        verify(view).printTotalPayment(200);
    }
}
