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
import java.util.List;

@WebServlet (value = "/edit-category-form")
public class UpdateFormGet extends HttpServlet {

    ICategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("categoryId"));
            Category category = categoryDAO.getCategoryById(id);
            req.setAttribute("categoryList", category);
            req.setAttribute("categoryId", id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("category/edit.jsp");
            requestDispatcher.forward(req, resp);
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
