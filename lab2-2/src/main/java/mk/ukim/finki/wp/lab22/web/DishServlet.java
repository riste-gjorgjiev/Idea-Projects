package mk.ukim.finki.wp.lab22.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab22.model.Chef;
import mk.ukim.finki.wp.lab22.service.ChefService;
import mk.ukim.finki.wp.lab22.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebServlet(urlPatterns = "/dish")
public class DishServlet extends HttpServlet {
    private final DishService dishService;
    private final ChefService chefService;

    @Autowired
    public DishServlet(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String chefIdStr = req.getParameter("chefIdStr");

        if (chefIdStr == null || chefIdStr.isEmpty()){
            resp.sendRedirect("/listChefs");
            return;
        }

        Long chefId = Long.valueOf(chefIdStr);
        Chef selectedChef = chefService.findById(chefId);

        req.setAttribute("selectedChef", selectedChef);
        req.setAttribute("dishes", dishService.listDishes());

        req.getRequestDispatcher("/dishesList").forward(req, resp);
    }
}
