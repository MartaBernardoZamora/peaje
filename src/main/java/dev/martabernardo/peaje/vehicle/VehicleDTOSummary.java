package dev.martabernardo.peaje.vehicle;

public record VehicleDTOSummary(String vehicleId, int payment, String type) {
    public static VehicleDTOSummary from(Vehicle vehicle) {
        return new VehicleDTOSummary(
            vehicle.getVehicleId(), 
            vehicle.calculatePayment(), 
            vehicle.getClass().getSimpleName());
    }
}
