package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/create-book-form")
public class CreateFormGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            List<String> publisherList = bookDAO.getAllPublisher();
            request.setAttribute("publisherList", publisherList);

            List<String> bookCategory = bookDAO.getCategoryByBookId(bookId);

            List<Category> categoryList = bookDAO.getAllCategory();
            request.setAttribute("categoryList", categoryList);

            RequestDispatcher rd = request.getRequestDispatcher("book/create.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
