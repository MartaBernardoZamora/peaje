package dev.martabernardo.peaje.station;

import java.util.Optional;

public interface StationRepository {

    Optional<Station> findById(long l);

}
