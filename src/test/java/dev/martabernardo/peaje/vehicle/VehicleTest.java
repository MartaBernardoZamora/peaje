package dev.martabernardo.peaje.vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleTest {
    @Test
    @DisplayName("Test getVehicleId")
    public void getVehicleIdTest() {
        Vehicle vehicle = new Vehicle("1234MNL");
        String vehicleId = vehicle.getVehicleId();
        assertThat(vehicleId, is("1234MNL"));
    }
}
