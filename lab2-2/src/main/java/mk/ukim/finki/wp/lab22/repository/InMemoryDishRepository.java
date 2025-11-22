package mk.ukim.finki.wp.lab22.repository;

import mk.ukim.finki.wp.lab22.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab22.model.Dish;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class InMemoryDishRepository implements DishRepository{
    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findDishById(String dishId) {
        return DataHolder.dishes.stream().filter(dish -> dish.getDishId().equals(dishId)).findFirst().orElse(null);
    }
}
