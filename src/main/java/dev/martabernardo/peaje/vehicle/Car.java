package dev.martabernardo.peaje.vehicle;

public class Car extends Vehicle{

    public Car(String vehicleId) {
        super(vehicleId);
    }

    @Override
    public int calculatePayment() {
        return 100;
    }


}
