package org.example.bookmanagement.controller.user;

import org.example.bookmanagement.service.userDAO.IUserDAO;
import org.example.bookmanagement.service.userDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (value = "/search-user")
public class SearchByNameFormGet extends HttpServlet {
    IUserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        try {
            req.setAttribute("userList", userDAO.searchByName(userName));
            req.getRequestDispatcher("user/list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
