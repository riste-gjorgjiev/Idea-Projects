package mk.ukim.finki.wp.lab22.repository;

import mk.ukim.finki.wp.lab22.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findDishById (String dishId);
}
