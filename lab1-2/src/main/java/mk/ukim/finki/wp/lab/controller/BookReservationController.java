package mk.ukim.finki.wp.lab.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class BookReservationController {

    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String confirmReservation(
            @RequestParam String bookTitle,
            @RequestParam String readerName,
            @RequestParam String readerAddress,
            @RequestParam Integer numberOfCopies,
            HttpServletRequest req, Model model
    ) {
        String clientIpAddress = req.getRemoteAddr();
        BookReservation reservation = this.bookReservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);
        model.addAttribute("reservation", reservation);
        return "reservationConfirmation";
    }
}
