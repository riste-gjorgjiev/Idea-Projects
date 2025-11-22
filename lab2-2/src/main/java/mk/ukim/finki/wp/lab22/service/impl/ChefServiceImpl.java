package mk.ukim.finki.wp.lab22.service.impl;

import mk.ukim.finki.wp.lab22.model.Chef;
import mk.ukim.finki.wp.lab22.model.Dish;
import mk.ukim.finki.wp.lab22.repository.ChefRepository;
import mk.ukim.finki.wp.lab22.repository.DishRepository;
import mk.ukim.finki.wp.lab22.service.ChefService;
import mk.ukim.finki.wp.lab22.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return this.chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return this.chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Chef chef = chefRepository.findById(chefId).orElseThrow(() -> new RuntimeException("Chef not found"));
        Dish dish = dishRepository.findDishById(dishId);

        if (!(chef.getDishes().contains(dish))){
            chef.getDishes().add(dish);
        }
        return this.chefRepository.save(chef);
    }
}
