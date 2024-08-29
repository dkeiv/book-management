package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/delete-book")
public class DeleteFormPost extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            Book book = bookDAO.getBookById(bookId);

            if(book == null) {
                request.setAttribute("message", "Book does not exist");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
            if(book.isBorrowed()) {
                request.setAttribute("message", "Book is being borrowed");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            bookDAO.deleteBook(bookId);
            request.setAttribute("message", "Book deleted!");
            request.getRequestDispatcher("success.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
