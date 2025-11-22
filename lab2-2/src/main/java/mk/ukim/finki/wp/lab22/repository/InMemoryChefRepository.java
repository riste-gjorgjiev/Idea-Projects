package mk.ukim.finki.wp.lab22.repository;

import mk.ukim.finki.wp.lab22.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab22.model.Chef;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository{

    @Override
    public List<Chef> findAll() {
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        return DataHolder.chefs.stream().filter(chef -> chef.getId().equals(id)).findFirst();
    }

    @Override
    public Chef save(Chef chef) {
        if (chef.getId() != null){
            DataHolder.chefs.removeIf(chef1 -> chef1.getId().equals(chef.getId()));
        } else {
            Long newId = DataHolder.chefs.stream()
                    .mapToLong(Chef::getId)
                    .max().orElse(0L) + 1;
            chef.setId(newId);
        }
        DataHolder.chefs.add(chef);
        return chef;
    }
}
