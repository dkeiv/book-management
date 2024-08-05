package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet (value = "/list-borrow")
public class ListGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BorrowBook> borrowBookList = bookDAO.getAllBorrowBook();
            request.setAttribute("borrowBookList", borrowBookList);
            request.getRequestDispatcher("/borrow/list.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            throw new RuntimeException(e);
        }
    }
}
