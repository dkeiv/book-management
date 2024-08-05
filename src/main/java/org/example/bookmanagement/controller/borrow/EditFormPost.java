package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/edit-borrow")
public class EditFormPost extends HttpServlet {
    private final BookDAOInterface bookDAO = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int borrowId = Integer.parseInt(request.getParameter("borrowId"));

            String bookIsbn = request.getParameter("bookIsbn");
            int userId = Integer.parseInt(request.getParameter("userId"));
            Date borrowDate = Date.valueOf(request.getParameter("borrowDate"));
            Date returnDate = Date.valueOf(request.getParameter("returnDate"));
            String borrowStatus = request.getParameter("borrowStatus");
            bookDAO.updateBorrow(new BorrowBook(borrowId, userId, bookIsbn, borrowStatus, borrowDate, returnDate));

            request.setAttribute("message", "Edit successful");
            request.getRequestDispatcher("success.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
