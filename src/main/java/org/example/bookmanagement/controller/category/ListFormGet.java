package org.example.bookmanagement.controller.category;

import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/list-category")
public class ListFormGet extends HttpServlet {
    private static CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryDAO.selectAllCategory();
        req.setAttribute("categoryList", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
