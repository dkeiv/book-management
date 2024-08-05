package org.example.bookmanagement.controller.librarian;

import org.example.bookmanagement.model.Librarian;
import org.example.bookmanagement.service.ILibrarianDAO;
import org.example.bookmanagement.service.LibrarianDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/list-librarian")
public class ListGet extends HttpServlet {
    private static final ILibrarianDAO librarianDAO = new LibrarianDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Librarian> librarianList = librarianDAO.showAllLibrarian();
        req.setAttribute("librarianList", librarianList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarian/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
