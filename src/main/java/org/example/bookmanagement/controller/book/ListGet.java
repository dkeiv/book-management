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
            int page = 1;
            int recordsPerPage = 5;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            List<Book> bookList1 = bookDAO.getAllBook((page - 1) * recordsPerPage, recordsPerPage);
            int numberOfRows = bookDAO.getNumberOfRows();
            int numberOfPage = (int)Math.ceil((double)numberOfRows / recordsPerPage);
            request.setAttribute("bookList", bookList1);
            request.setAttribute("numberOfPage", numberOfPage);
            request.setAttribute("currentPage", page);

            List<Category> categoryList = categoryDAO.selectAllCategory();
            request.setAttribute("categoryList", categoryList);

            RequestDispatcher view = request.getRequestDispatcher("book/list.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
