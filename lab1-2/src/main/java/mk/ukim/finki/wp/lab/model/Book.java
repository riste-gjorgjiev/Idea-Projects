package mk.ukim.finki.wp.lab.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    String title;
    String genre;
    double averageRating;
    private Long id;
    private Author author;

    public Book(String title, String genre, double averageRating, Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.id = (long) (Math.random()*1000);
        this.author = author;
    }
}


