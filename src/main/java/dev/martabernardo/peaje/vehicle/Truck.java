package dev.martabernardo.peaje.vehicle;

import jakarta.persistence.Entity;

@Entity
public class Truck extends Vehicle{

    private int axlex;

    public Truck(String vehicleId, int axlex) {
        super(vehicleId);
        this.axlex = axlex;
    }

    public int calculatePayment() {
        return axlex * 50;
    }
}
