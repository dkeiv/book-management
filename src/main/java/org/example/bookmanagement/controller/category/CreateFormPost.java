package org.example.bookmanagement.controller.category;

import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import org.example.bookmanagement.service.categoryDAO.ICategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value ="/create-category")
public class CreateFormPost extends HttpServlet {
    ICategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        Category category = new Category(categoryName);
        try {
            categoryDAO.createCategory(category);
            req.setAttribute("message", "Deleted Successfully");
            RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
