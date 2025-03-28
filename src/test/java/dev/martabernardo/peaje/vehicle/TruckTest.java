package dev.martabernardo.peaje.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TruckTest {
    @Test
    @DisplayName("Test calculatePayment")
    public void calculatePaymentTest() {
        int axlex = 3;
        Truck truck = new Truck("1234MNL", axlex);
        int payment = truck.calculatePayment();
        assertThat(truck, is(instanceOf(Vehicle.class)));
        assertThat(payment, is(150));
    }

}
