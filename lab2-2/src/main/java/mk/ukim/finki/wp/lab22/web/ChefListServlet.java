package mk.ukim.finki.wp.lab22.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab22.model.Chef;
import mk.ukim.finki.wp.lab22.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {
    private final ChefService chefService;

    @Autowired
    public ChefListServlet(ChefService chefService) {
        this.chefService = chefService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Chef> chefs = this.chefService.listChefs();
        req.setAttribute("chefs", chefs);
        req.getRequestDispatcher("/listChefs").forward(req, resp);

    }
}
