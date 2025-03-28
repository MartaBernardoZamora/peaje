package dev.martabernardo.peaje.vehicle;

import jakarta.persistence.Entity;

@Entity
public class Moto extends Vehicle{

    public Moto() {}
    public Moto(String vehicleId) {
        super(vehicleId);
    }

    @Override
    public int calculatePayment() {
        return 50;
    }
    
}
