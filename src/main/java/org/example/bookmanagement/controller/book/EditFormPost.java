package org.example.bookmanagement.controller.book;


import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/edit-book")
public class EditFormPost extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Book book = new Book();
            int id = Integer.parseInt(request.getParameter("bookId"));
            book.setIsbn(request.getParameter("bookIsbn"));
            book.setName(request.getParameter("bookName"));
            book.setPublisher(request.getParameter("bookPublisher"));
            book.setDescription(request.getParameter("bookDescription"));
            book.setCondition(request.getParameter("bookCondition"));
            book.setImgUrl(request.getParameter("bookImage"));
            book.setBorrowed(Boolean.parseBoolean(request.getParameter("borrowedStatus")));

            String[] bookCategory = request.getParameterValues("bookCategory");

            bookDAO.updateBook(id, book);
            bookDAO.addBookCategory(book, bookCategory);

            request.setAttribute("message", " Edit Success");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            throw new RuntimeException(e);
        }
    }
}
