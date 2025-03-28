package dev.martabernardo.peaje.station;

import java.util.HashSet;
import java.util.Set;

import dev.martabernardo.peaje.vehicle.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_station")
    private Long id;
    private String name;
    private String city;
    
    public Station() {}
    
    public Station(String name, String city) {
        this.name = name;
        this.city = city;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "station_vehicle",
        joinColumns = @JoinColumn(name = "station_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> vehicles = new HashSet<>();

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public long getId() {
        return id;
    }
}
