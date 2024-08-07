package org.example.bookmanagement.controller.librarian;

import org.example.bookmanagement.model.Librarian;
import org.example.bookmanagement.service.librarianDAO.ILibrarianDAO;
import org.example.bookmanagement.service.librarianDAO.LibrarianDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login-form")
public class LoginFormPost extends HttpServlet {
    private static final ILibrarianDAO librarianDAO = new LibrarianDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        Librarian librarian = librarianDAO.searchByEmail(email);
        if (librarian != null && librarian.getPassword().equals(password)) {
            // Đăng nhập thành công
            req.getSession().setAttribute("librarian", librarian);
            resp.sendRedirect(req.getContextPath() + "/list-librarian");
        } else {
            // Đăng nhập thất bại
            req.setAttribute("errorMessage", "Invalid email or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
