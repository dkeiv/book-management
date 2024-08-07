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

@WebServlet(value = "/edit-librarian")
public class EditFormPost extends HttpServlet {
    private static final ILibrarianDAO librarianDAO = new LibrarianDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Librarian librarian = new Librarian(id,name,email,password);
        librarianDAO.updateLibrarian(librarian);
        // Redirect to success page
        try {
            resp.sendRedirect(req.getContextPath() + "/list-librarian");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

