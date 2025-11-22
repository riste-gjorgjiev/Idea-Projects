package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.BookReservation;
import mk.ukim.finki.wp.lab1.repository.BookReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        BookReservation reservation = new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies);
        bookReservationRepository.save(reservation);
        return reservation;
    }
}
