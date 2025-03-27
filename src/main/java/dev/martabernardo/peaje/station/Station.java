package dev.martabernardo.peaje.station;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "station")
public class Station {

    private String name;
    private String city;
    
    
    public Station(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}
