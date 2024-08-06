package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/create-book")
public class CreateFormPost extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String isbn = request.getParameter("bookIsbn");
            String name = request.getParameter("bookName");
            String condition = request.getParameter("bookCondition");
            String publisher = request.getParameter("bookPublisher");
            String bookImage = request.getParameter("bookImage");
            String bookDescription = request.getParameter("bookDescription");
            String[] categoryIdList = request.getParameterValues("bookCategory");

            Book book = new Book(isbn, name, publisher, bookDescription, bookImage, condition, false);

            bookDAO.insertBook(book);
            bookDAO.addBookCategory(book, categoryIdList);

            request.setAttribute("message", "Created Successfully");
            request.getRequestDispatcher("success.jsp").forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            throw new RuntimeException(e);
        }
    }
}
