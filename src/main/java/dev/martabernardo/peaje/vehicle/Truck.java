package dev.martabernardo.peaje.vehicle;

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
