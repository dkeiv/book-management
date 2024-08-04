package org.example.bookmanagement.controller.user;

import org.example.bookmanagement.model.User;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import userDAO.IUserDAO;
import userDAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/list-user")
public class ListFormGet extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = userDAO.getAllUser();
        req.setAttribute("userList", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
