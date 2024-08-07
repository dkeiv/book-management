package org.example.bookmanagement.controller.librarian;

import org.example.bookmanagement.model.Librarian;
import org.example.bookmanagement.service.librarianDAO.ILibrarianDAO;
import org.example.bookmanagement.service.librarianDAO.LibrarianDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-librarian-form")

public class DeleteFormGet extends HttpServlet {
    private static final ILibrarianDAO librarianDAO =new LibrarianDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Librarian librarian = librarianDAO.searchByID(id);
        req.setAttribute("librarian", librarian);


        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/delete.jsp");
        dispatcher.forward(req, resp);
    }
}