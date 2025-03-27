package dev.martabernardo.peaje.station;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "station")
public class Station {

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
