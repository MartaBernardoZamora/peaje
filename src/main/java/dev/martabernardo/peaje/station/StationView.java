package dev.martabernardo.peaje.station;

public class StationView {

    public void printStationName(Station station) {
        String name = station.getName();
        String city = station.getCity();
        System.out.println("Peaje " + name + " (" + city +")");        
    }

}
