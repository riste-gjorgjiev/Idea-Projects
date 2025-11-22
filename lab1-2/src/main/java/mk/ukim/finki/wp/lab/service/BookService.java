package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    List<Book> filter(String text, Double rating);
    Optional<Book> findBookById(Long id);

    Book save (Long bookId, String title, String genre, Double averageRating, Long authorId);

    void deleteById(Long id);
}
