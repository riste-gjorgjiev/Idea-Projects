package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.model.Chef;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById (Long id);
    Chef save(Chef chef);
}
