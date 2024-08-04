package org.example.bookmanagement.controller.category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value ="/create-category-form")
public class CreateFormGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
