package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(value = "/create-borrow")
public class CreateFormPost extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookIsbn = request.getParameter("bookIsbn");
            Book book = bookDAO.getBookByIsbn(bookIsbn);

            if (book.isBorrowed()) {
                 request.setAttribute("invalidBookMsg", "Book is already borrowed");
                 request.getRequestDispatcher("borrow/create.jsp" ).forward(request, response);
                 return;
            }

            int userId = Integer.parseInt(request.getParameter("userId"));

            Date borrowDate = Date.valueOf(request.getParameter("borrowDate"));
            Date returnDate = Date.valueOf(request.getParameter("returnDate"));
            String borrowStatus = request.getParameter("borrowStatus").toUpperCase();

            BorrowBook borrowBook = new BorrowBook(userId, bookIsbn, borrowStatus, borrowDate, returnDate);
            bookDAO.insertBorrowBook(borrowBook);

            request.setAttribute("successMsg", "Book Borrowed successfully");
            request.getRequestDispatcher("borrow/create.jsp" ).forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("exception", e);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
            throw new RuntimeException(e);
        }
    }
}
