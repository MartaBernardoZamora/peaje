package dev.martabernardo.peaje.vehicle;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle{

    public Car() {}

    public Car(String vehicleId) {
        super(vehicleId);
    }

    @Override
    public int calculatePayment() {
        return 100;
    }


}
