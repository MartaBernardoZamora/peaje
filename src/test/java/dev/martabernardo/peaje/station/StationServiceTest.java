package dev.martabernardo.peaje.station;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    @DisplayName("Vehicle list with payment and type")
    void getVehicleListWithPaymentAndType() {
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
        assertThat(vehicles, containsInAnyOrder(
            new VehicleDTOSummary("CAR001", 100, "Car"),
            new VehicleDTOSummary("MOTO001", 50, "Moto"),
            new VehicleDTOSummary("TRK001", 150, "Truck")
        ));
        verify(stationRepository).findById(1L); 
    }
    @Test
    @DisplayName("Test get Total payment")
    void getTotalPaymentTest() {
        StationService stationService = new StationService(stationRepository);

        Station station = new Station("Peaje Norte", "Oviedo");
        station.getVehicles().addAll(List.of(
            new Car("CAR001"),      
            new Moto("MOTO001"),  
            new Truck("TRK001", 3)  
        ));

        when(stationRepository.findById(1L)).thenReturn(Optional.of(station));   

        int totalPayment = stationService.getTotalPayment(1L);
        assertThat(totalPayment, is(300));
        verify(stationRepository).findById(1L); 
    }
    
    @Test
    @DisplayName("Test getAllStations")
    void getAllStationsTest() {
        StationService stationService = new StationService(stationRepository);

        Station station1 = new Station("Peaje Norte", "Oviedo");
        Station station2 = new Station("Peaje Sur", "Sevilla");

        when(stationRepository.findAll()).thenReturn(List.of(station1, station2));

        List<Station> allStations = stationService.getAllStations();
        assertThat(allStations, notNullValue());
        assertThat(allStations, hasSize(2));
        verify(stationRepository).findAll(); 
    }
}
