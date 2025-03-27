package dev.martabernardo.peaje.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public abstract class Vehicle {
    
    private String vehicleId;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public abstract int calculatePayment();  
}
