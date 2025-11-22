package mk.ukim.finki.wp.lab22.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab22.model.Chef;
import mk.ukim.finki.wp.lab22.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        chefs.add(new Chef(1L, "Anthony", "Bourdain", "Anthony Michael Bourdain was an American celebrity chef, author and travel documentarian."));
        chefs.add(new Chef(2L, "Wolfgang", "Puck", "Wolfgang Johannes Puck is an Austrian-born American chef and restaurateur."));
        chefs.add(new Chef(3L, "Alvin", "Leung", "Alvin Leung King-Lon is a Canadian chef and television personality."));
        chefs.add(new Chef(4L, "Gordon", "Ramsay", "Gordon James Ramsay is a British celebrity chef, restaurateur, television presenter, and writer."));
        chefs.add(new Chef(5L, "Michael", "Bonacini", "Michael Bonacini is a Welsh-Canadian chef of Italian family origins who owns eleven restaurants in Toronto, Ontario"));

        dishes.add(new Dish("fms", "Fried Mortadella Sandwich", "Italian-American", 15));
        dishes.add(new Dish("ssp", "Smoked Salmon Pizza", "Italian-American", 120));
        dishes.add(new Dish("sob", "Sex on a Beach", "None", 120));
        dishes.add(new Dish("bw", "Beef Wellington", "British-American", 180));
        dishes.add(new Dish("hss", "House Smoked Salmon", "Italian-American", 180));
    }

}

