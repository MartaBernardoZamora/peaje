package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;
@ExtendWith(MockitoExtension.class)
public class StationControllerTest {

    @Mock
    StationService service;


    @Test
    @DisplayName("Test getAllData")
    void getStationDataTest(){

        StationController stationController = new StationController(service);
        List<VehicleDTOSummary> vehicles = List.of(new VehicleDTOSummary("CAR001", 100, "Car"),
            new VehicleDTOSummary("MOTO001", 50, "Moto"),
            new VehicleDTOSummary("TRK001", 150, "Truck"));

        when(service.getVehicleList(1L)).thenReturn(vehicles);

        stationController.getAllData(1L);

        assertThat(vehicles, notNullValue());
        assertThat(vehicles, hasSize(3));
        assertThat(vehicles, containsInAnyOrder(
            new VehicleDTOSummary("CAR001", 100, "Car"),
            new VehicleDTOSummary("MOTO001", 50, "Moto"),
            new VehicleDTOSummary("TRK001", 150, "Truck")
        ));
    }
}
