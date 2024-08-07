package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import org.example.bookmanagement.service.categoryDAO.ICategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/search-book")
public class SearchGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    ICategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryDAO.selectAllCategory();
        List<Book> bookCategoryList;
        List<Book> result;
        try {
            String bookName = request.getParameter("bookName");
            List<Book> bookList = bookDAO.getBookByName(bookName);

            if (!request.getParameter("categoryId").isEmpty()) {
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                bookCategoryList = bookDAO.searchBookByCategoryId(categoryId);
                result = bookList.stream().filter(bookCategoryList::contains).collect(Collectors.toList());
            } else {
                result = bookList;
            }

            request.setAttribute("bookList", result);
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("book/list.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
