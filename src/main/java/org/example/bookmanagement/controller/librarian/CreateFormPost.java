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
@WebServlet(value = "/create-librarian")
public class CreateFormPost extends HttpServlet {
    private static final ILibrarianDAO librarianDAO =new LibrarianDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        librarianDAO.insertLibrarian(new Librarian(name,email,password));
        resp.sendRedirect("/list-librarian");
    }
}
