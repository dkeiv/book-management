package org.example.bookmanagement.controller.category;

import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/delete-category")
public class DeleteFormPost extends HttpServlet {
    CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        Category category = new Category(id, name);
        try {
            categoryDAO.deleteCategory(category);
            req.setAttribute("message", "Deleted Successfully");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
