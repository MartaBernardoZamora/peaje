package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.martabernardo.peaje.vehicle.Car;
import dev.martabernardo.peaje.vehicle.Moto;
import dev.martabernardo.peaje.vehicle.Truck;
import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;

@ExtendWith(MockitoExtension.class)
public class StationServiceTest {
    @Mock
    private StationRepository stationRepository;

    @Test
    @DisplayName("Vehicle list with payment")
    void getVehicleListWithPayment() {
        StationService stationService = new StationService(stationRepository);

        Station station = new Station("Peaje Norte", "Oviedo");
        station.getVehicles().addAll(List.of(
            new Car("CAR001"),    
            new Moto("MOTO001"),  
            new Truck("TRK001", 3)  
        ));

        when(stationRepository.findById(1L)).thenReturn(Optional.of(station));

        List<VehicleDTOSummary> vehicles = stationService.getVehicleList(1L);
        System.out.println(vehicles);

        assertThat(vehicles, notNullValue());
        assertThat(vehicles, hasSize(3));
        verify(stationRepository).findById(1L); 
    }
}
