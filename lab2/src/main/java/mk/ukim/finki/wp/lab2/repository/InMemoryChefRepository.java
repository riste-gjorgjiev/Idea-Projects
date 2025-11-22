package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2.model.Chef;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        for (int i = 0; i < DataHolder.chefs.size(); i++) {
            Chef currChef = DataHolder.chefs.get(i);

            if (chef.getId() != null && currChef.getId().equals(chef.getId())){
                DataHolder.chefs.set(i, chef);
                return chef;
            }
        }
        DataHolder.chefs.add(chef);
        return chef;
    }
}
