package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return this.bookRepository.searchBooks(text, rating);
    }

    @Override
    public List<Book> filter(String text, Double rating) {
        List<Book> books = this.bookRepository.findAll();

        return books.stream()
                .filter(book -> text == null || text.trim().isEmpty() ||
                        book.getTitle().toLowerCase().contains(text.toLowerCase()))
                .filter(book -> rating == null || book.getAverageRating() >= rating)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Book save(Long bookId, String title, String genre, Double averageRating, Long authorId) {
        Author author = authorService.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));

        Book newBook;
        if (bookId != null){
            newBook = this.bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " was not found"));
        } else {
            newBook = new Book();
        }
        newBook.setTitle(title);
        newBook.setGenre(genre);
        newBook.setAverageRating(averageRating);
        newBook.setAuthor(author);

        return this.bookRepository.save(newBook);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
