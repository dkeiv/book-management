package org.example.bookmanagement.controller.librarian;

import org.example.bookmanagement.service.librarianDAO.ILibrarianDAO;
import org.example.bookmanagement.service.librarianDAO.LibrarianDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-librarian")
public class DeleteFormPost extends HttpServlet {
    private static final ILibrarianDAO librarianDAO = new LibrarianDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        librarianDAO.deleteLibrarian(id);
        resp.sendRedirect(req.getContextPath() + "/list-librarian");
    }
}

