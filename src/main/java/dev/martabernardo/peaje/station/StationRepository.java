package dev.martabernardo.peaje.station;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findById(long l);

}
