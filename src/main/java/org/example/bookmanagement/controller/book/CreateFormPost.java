package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.service.BookDAO;
import org.example.bookmanagement.service.BookDAOInterface;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(value = "/creat-book")
public class CreateFormPost extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("bookId"));
            String name = request.getParameter("bookName");
            String condition = request.getParameter("bookCondition");
            String publisher = request.getParameter("bookPublisher");
            String[] bookCategory = request.getParameterValues("bookCategory");
            String bookImage = request.getParameter("bookImage");
            String bookDescription = request.getParameter("bookDescription");

            Book book = new Book(id, name, publisher, bookDescription, bookImage, condition, false);

            bookDAO.insertBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
