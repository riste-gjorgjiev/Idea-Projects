package mk.ukim.finki.wp.wp2025.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"", "/hello"})
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");

        if (name == null) name = "X";
        if (surname == null) surname = "Y";
        if (age == null) age = "20";

        PrintWriter writer = resp.getWriter();
        writer.format("<html><head></head><body><h1>Hello %s %s <br> Your age is %s</h1></body>", name, surname, age);
    }
}