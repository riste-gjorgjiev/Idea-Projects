package mk.ukim.finki.wp.lab22.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Dish {
    String dishId;
    String name;
    String cuisine;
    int preparationTime;
}
