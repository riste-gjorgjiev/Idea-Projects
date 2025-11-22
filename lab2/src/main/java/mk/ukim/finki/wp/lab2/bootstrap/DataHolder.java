package mk.ukim.finki.wp.lab2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

//    @PostConstruct
//    public void initChefs() {
//        chefs.add(new Chef(Integer.toUnsignedLong(5), "Gordon", "Ramsay", "British celebrity chef, restaurateur, television presenter, and writer"));
//    }
//    @PostConstruct
//    public void initDishes() {
//        dishes.add(new Dish());
//    }

}
