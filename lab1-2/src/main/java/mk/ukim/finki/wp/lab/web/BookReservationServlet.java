package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

public class BookReservationServlet extends HttpServlet {
    private final BookReservationService reservationService;
    private final SpringTemplateEngine springTemplateEngine;

    public BookReservationServlet(BookReservationService reservationService, SpringTemplateEngine springTemplateEngine) {
        this.reservationService = reservationService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bookTitle = req.getParameter("bookTitle");
        String readerName= req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numberOfCopies = 0;
        try {
            numberOfCopies = Integer.parseInt(req.getParameter("numCopies"));
        }catch (NumberFormatException ignored){}

        String clientIpAddress = req.getRemoteAddr();

        BookReservation reservation = this.reservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);

        WebContext context = new WebContext(JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp));

        context.setVariable("reservation", reservation);
        context.setVariable("clientIpAddress", clientIpAddress);

        resp.setContentType("text/html;charset=UTF-8");
        this.springTemplateEngine.process("reservationConfirmation", context, resp.getWriter());
    }
}
