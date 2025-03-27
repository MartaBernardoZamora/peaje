package dev.martabernardo.peaje.vehicle;

public class Moto extends Vehicle{
    public Moto(String vehicleId) {
        super(vehicleId);
    }

    @Override
    public int calculatePayment() {
        return 50;
    }
    
}
