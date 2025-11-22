package mk.ukim.finki.wp.lab.controller;

import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) String error,
            Model model
    ){
        model.addAttribute("searchText", text);
        model.addAttribute("searchRating", rating);

        if (text != null || rating != null){
            model.addAttribute("books", this.bookService.filter(text, rating));
        } else {
            model.addAttribute("books", this.bookService.listAll());
        }
        if (error != null && !error.isEmpty()){
            model.addAttribute("haseError", true);
            model.addAttribute("error", error);
        }
        return "listBooks";
    }

    @GetMapping("/add")
    public String addBookPage(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/book-form/{id}")
    public String editBookPage(@PathVariable Long id, Model model){
        return this.bookService.findBookById(id).map(book -> {
            model.addAttribute("book", book);
            model.addAttribute("authors", authorService.findAll());
            return "book-form";
        }).orElseGet(() -> "redirect:/books?error=BookNotFound");
    }

    @GetMapping("/reservations/form/{id}")
    public String showReservationForm(@PathVariable Long id, Model model){
        return this.bookService.findBookById(id).
                map(book -> {model.addAttribute("book", book);
                return "reservationForm";
                }).orElseGet(() -> "redirect:/books?error=BooksNotFound");
    }

    @PostMapping
    public String saveOrUpdateBook(
            @RequestParam(required = false) Long bookId,
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam(required = false) Double averageRating,
            @RequestParam Long authorId
    ) {
        try {
            this.bookService.save(bookId, title, genre, averageRating, authorId);
            return "redirect:/books";
        } catch (RuntimeException e) {
            return "redirect/books?error=" + e.getMessage();
        }
    }


    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        try {
            this.bookService.deleteById(id);
            return "redirect:/books";
        } catch (RuntimeException ex){
            return "redirect:/books?error=" + ex.getMessage();
        }
    }
}
