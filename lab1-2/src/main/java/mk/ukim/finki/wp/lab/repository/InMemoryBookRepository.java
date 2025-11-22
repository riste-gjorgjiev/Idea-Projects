package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepository implements BookRepository{

    private static Long bookIdCounter = 1L;
    private static Long nextBookId(){
        if (DataHolder.books.isEmpty()){
            return bookIdCounter++;
        }
        return DataHolder.books.stream().mapToLong(Book :: getId).max().orElse(0L) + 1;
    }

    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream().filter(book -> {
            boolean titleMatches = (text == null || text.trim().isEmpty())
                || book.getTitle().toLowerCase().contains(text.toLowerCase());
            boolean ratingMatches = (rating == null)
                    || book.getAverageRating() >= rating;
            return titleMatches && ratingMatches;
        }).collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null){
            book.setId(nextBookId());
            book.setId(nextBookId());
            DataHolder.books.add(book);
        } else {
            DataHolder.books.removeIf(book1 -> book1.getId().equals(book.getId()));
            DataHolder.books.add(book);
        }
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
    }
}
