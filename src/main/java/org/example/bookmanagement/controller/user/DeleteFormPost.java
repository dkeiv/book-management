package org.example.bookmanagement.controller.user;

import org.example.bookmanagement.model.User;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import userDAO.IUserDAO;
import userDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/delete-user")
public class DeleteFormPost extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("user-name");
        String address = req.getParameter("address");
        String course = req.getParameter("course");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        boolean active = Boolean.parseBoolean(req.getParameter("active"));
        User user = new User(id, userName, address, course, birthday, active);
        try {
            boolean isDeleted = userDAO.deleteUser(user);
            if (isDeleted) {
                req.setAttribute("message", "Deleted Successfully");
            } else {
                req.setAttribute("message", "Deletion Failed");
            }
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}