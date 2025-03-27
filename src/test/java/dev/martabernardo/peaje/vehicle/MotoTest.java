package dev.martabernardo.peaje.vehicle;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MotoTest {
    @Test
    @DisplayName("Test calculatePayment")
    public void calculatePaymentTest() {
        Moto moto = new Moto("1234MNL");
        int payment = moto.calculatePayment();
        assertThat(moto, is(instanceOf(Vehicle.class)));
        assertThat(payment, is(50));
    }

}
