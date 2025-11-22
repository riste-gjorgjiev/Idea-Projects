package mk.ukim.finki.wp.lab22.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab22.model.Chef;
import mk.ukim.finki.wp.lab22.repository.ChefRepository;
import mk.ukim.finki.wp.lab22.service.ChefService;
import mk.ukim.finki.wp.lab22.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebServlet(urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private final ChefService chefService;
    private final DishService dishService;

    @Autowired
    public ChefDetailsServlet(ChefService chefService, DishService dishService) {
        this.chefService = chefService;
        this.dishService = dishService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String chefIdStr = req.getParameter("chefId");
        String dishId = req.getParameter("dishId");

        if (chefIdStr == null || chefIdStr.isEmpty() || dishId == null || dishId.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing Chef ID or Dish ID");
            return;
        }

        Long chefId = Long.valueOf(chefIdStr);
        Chef updatedChef;

        try{
            updatedChef = chefService.addDishToChef(chefId, dishId);
        }catch (RuntimeException e){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
            return;
        }

        req.setAttribute("chef", updatedChef);

        req.getRequestDispatcher("/chefDetails").forward(req, resp);
    }

}
