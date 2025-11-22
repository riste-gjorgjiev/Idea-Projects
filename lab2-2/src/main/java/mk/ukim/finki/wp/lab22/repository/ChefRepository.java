package mk.ukim.finki.wp.lab22.repository;

import ch.qos.logback.core.encoder.EchoEncoder;
import mk.ukim.finki.wp.lab22.model.Chef;

import java.util.List;
import java.util.Optional;

public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
}
