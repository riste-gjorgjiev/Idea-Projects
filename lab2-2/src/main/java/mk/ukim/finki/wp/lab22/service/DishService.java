package mk.ukim.finki.wp.lab22.service;

import mk.ukim.finki.wp.lab22.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}
