package dev.martabernardo.peaje.vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleTest {
    static class AnyVehicle extends Vehicle {
        public AnyVehicle(String vehicleId) {
            super(vehicleId);
        }

        @Override
        public int calculatePayment() {
            return 0;
        }
    }
    @Test
    @DisplayName("Test getVehicleId")
    public void getVehicleIdTest() {
        Vehicle vehicle = new AnyVehicle("1234MNL");
        String vehicleId = vehicle.getVehicleId();
        assertThat(vehicleId, is("1234MNL"));
    }
    @Test
    @DisplayName("Test calculatePayment")
    public void calculatePaymentTest() {
        Vehicle vehicle = new AnyVehicle("1234MNL");
        int payment = vehicle.calculatePayment();
        assertThat(payment, is(0));
    }
}
