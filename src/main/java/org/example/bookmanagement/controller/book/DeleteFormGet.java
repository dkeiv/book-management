package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet (value = "/delete-book-form")
public class DeleteFormGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("bookId"));
            List<String> publisherList = bookDAO.getAllPublisher();
            request.setAttribute("publisherList", publisherList);

            List<Category> categoryList = categoryDAO.selectAllCategory();
            request.setAttribute("categoryList", categoryList);

            List<String> bookCategoryList = bookDAO.getCategoryByBookId(id);
            request.setAttribute("bookCategoryList", bookCategoryList);

            Book book = bookDAO.getBookById(id);
            request.setAttribute("book", book);

            RequestDispatcher view = request.getRequestDispatcher("book/delete.jsp");
            view.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
