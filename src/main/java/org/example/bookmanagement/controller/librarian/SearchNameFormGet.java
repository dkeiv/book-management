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

@WebServlet(value = "/list-librarian?name=?")
public class SearchNameFormGet extends HttpServlet {
    private static final ILibrarianDAO librarianDAO = new LibrarianDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");  // Tên tham số phải khớp với tên trong form
            List<Librarian> librarianList = librarianDAO.searchByName(name);

            req.setAttribute("librarianList",librarianList );  // Cập nhật thuộc tính để phù hợp với tên trong JSP
            RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/list.jsp");
            dispatcher.forward(req, resp);
        }
    }

