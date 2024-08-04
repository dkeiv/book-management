package org.example.bookmanagement.controller.user;

import org.example.bookmanagement.model.User;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import org.example.bookmanagement.service.categoryDAO.ICategoryDAO;
import userDAO.IUserDAO;
import userDAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/edit-user")
public class EditFormPost extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user-name");
        String address = req.getParameter("address");
        String course = req.getParameter("course");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        boolean active = Boolean.parseBoolean(req.getParameter("active"));
        User user = new User( userName, address, course, birthday, active);

        try {
            userDAO.updateUser(user);

            req.setAttribute("message", "Success");

            RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");

            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
