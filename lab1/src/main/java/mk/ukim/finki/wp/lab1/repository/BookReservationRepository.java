package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.model.BookReservation;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReservationRepository {
    BookReservation save(BookReservation bookReservation);
}
