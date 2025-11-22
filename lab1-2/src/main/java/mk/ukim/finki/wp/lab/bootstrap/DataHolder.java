package mk.ukim.finki.wp.lab.bootstrap;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();
    private final AuthorRepository authorRepository;

    public DataHolder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }




    @PostConstruct
    public void init(){
        List<Author> authors = this.authorRepository.findAll();

        Author mccarthy = authors.get(0);
        Author kafka = authors.get(1);
        Author orwell = authors.get(2);

        books.add(new Book("The Lord of the Rings", "Fantasy", 4.5, null));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Sci-Fi", 4.2, null));
        books.add(new Book("1984", "Dystopian", 4.7, orwell));
        books.add(new Book("Metamorphosis", "Fiction", 4.3, kafka));
        books.add(new Book("To Kill a Mockingbird", "Fiction", 4.8, null));
        books.add(new Book("No Country for Old Men", "Fiction", 4.9, mccarthy));
    }
}
