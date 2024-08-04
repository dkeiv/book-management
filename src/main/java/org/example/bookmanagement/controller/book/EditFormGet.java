package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.BookDAO;
import org.example.bookmanagement.service.BookDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/edit-book-form")
public class EditFormGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));

        try {
            List<String> publisherList = bookDAO.getAllPublisher();
            request.setAttribute("publisherList", publisherList);

            List<Category> categoryList = bookDAO.getAllCategory();
            request.setAttribute("categoryList", categoryList);

            List<String> bookCategoryList = bookDAO.getCategoryByBookId(id);
            request.setAttribute("bookCategoryList", bookCategoryList);

            Book book = bookDAO.getBookById(id);
            request.setAttribute("book", book);

            RequestDispatcher view = request.getRequestDispatcher("book/edit.jsp");
            view.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

