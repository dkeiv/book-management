package org.example.bookmanagement.controller.user;

import org.example.bookmanagement.model.User;
import org.example.bookmanagement.service.userDAO.IUserDAO;
import org.example.bookmanagement.service.userDAO.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/delete-user-form")
public class DeleteFormGet extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userDAO.getUserById(id);
            req.setAttribute("user", user);
            req.setAttribute("id", id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/delete.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
