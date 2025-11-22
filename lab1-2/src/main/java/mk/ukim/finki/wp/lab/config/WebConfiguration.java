package mk.ukim.finki.wp.lab.config;

import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.web.BookListServlet;
import mk.ukim.finki.wp.lab.web.BookReservationServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
public class WebConfiguration {
    private final BookService bookService;
    private final BookReservationService bookReservationService;
    private final SpringTemplateEngine springTemplateEngine;

    public WebConfiguration(BookService bookService, BookReservationService bookReservationService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.bookReservationService = bookReservationService;
        this.springTemplateEngine = springTemplateEngine;
    }

//    @Bean
//    public ServletRegistrationBean<BookListServlet> bookListServlet() {
//        ServletRegistrationBean<BookListServlet> srb = new ServletRegistrationBean<>(
//                new BookListServlet(this.bookService, this.springTemplateEngine), "/");
//        srb.setLoadOnStartup(1);
//        return srb;
//    }
    @Bean
    public ServletRegistrationBean<BookReservationServlet> bookReservationServletServlet(){
        return new ServletRegistrationBean<>(new BookReservationServlet(this.bookReservationService, this.springTemplateEngine), "/bookReservation");
    }
}
