package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository{

    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < DataHolder.books.size(); i++) {
            if (DataHolder.books.get(i).getTitle().equals(text) && DataHolder.books.get(i).getAverageRating() >= rating){
                foundBooks.add(DataHolder.books.get(i));
            }
        }
        return foundBooks;
    }
}
