package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.service.impl.BookServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

public class BookListServlet extends HttpServlet {
    private final BookService bookService;
    private final SpringTemplateEngine springTemplateEngine;

    public BookListServlet(BookService bookService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("text");
        String ratingParam = req.getParameter("rating");
        Double rating = null;

        if (ratingParam != null && !ratingParam.isEmpty()){
            try {
                rating = Double.parseDouble(ratingParam);
            }catch (NumberFormatException ignored){}
        }

        List<Book> books;
        if ((searchText != null && !searchText.isEmpty()) || rating != null){
            books = bookService.searchBooks(searchText, rating);
        }else {
            books = bookService.listAll();
        }

        WebContext context = new WebContext(JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp));

        context.setVariable("books", books);
        context.setVariable("searchText", searchText);
        context.setVariable("ratingParm", ratingParam);

        resp.setContentType("text/html;charse1t=UTF-8");
        this.springTemplateEngine.process("listBooks", context, resp.getWriter());
    }
}
