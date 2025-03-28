package dev.martabernardo.peaje.station;

import java.util.List;

import dev.martabernardo.peaje.vehicle.VehicleDTOSummary;

public class StationView {

    public void printStation(Station station) {
        String name = station.getName();
        String city = station.getCity();
        System.out.println("Peaje " + name + " (" + city +")");        
    }

    public void printVehicles(List<VehicleDTOSummary> vehicles) {
        for (VehicleDTOSummary vehicle : vehicles) {
            System.out.println(vehicle.type() + "/" + vehicle.vehicleId() + "/" + vehicle.payment());
        }
    }

}
