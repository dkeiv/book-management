package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Book;
import org.example.bookmanagement.model.Category;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;
import org.example.bookmanagement.service.categoryDAO.CategoryDAO;
import org.example.bookmanagement.service.categoryDAO.ICategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/list-book")
public class ListGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    ICategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Book> bookList = bookDAO.getAllBook();
            request.setAttribute("bookList", bookList);

            List<Category> categoryList = categoryDAO.selectAllCategory();
            request.setAttribute("categoryList", categoryList);

            System.out.println(categoryList);

            RequestDispatcher view = request.getRequestDispatcher("book/list.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
