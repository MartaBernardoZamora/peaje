package dev.martabernardo.peaje.vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CarTest {
    @Test
    @DisplayName("Test calculatePayment")
    public void calculatePaymentTest() {
        Car car = new Car("1234MNL");
        int payment = car.calculatePayment();
        assertThat(car, is(instanceOf(Vehicle.class)));
        assertThat(payment, is(100));
    }

}
