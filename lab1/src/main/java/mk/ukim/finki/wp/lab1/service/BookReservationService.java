package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.BookReservation;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);
}
