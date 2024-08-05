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
import java.util.List;

@WebServlet (value = "/search-book")
public class SearchGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String bookName = request.getParameter("bookName");
            List<Book> bookList = bookDAO.getBookByName(bookName);

            request.setAttribute("bookList", bookList);
            request.getRequestDispatcher("book/list.jsp").forward(request, response);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
