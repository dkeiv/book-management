package org.example.bookmanagement.controller.book;

import org.example.bookmanagement.dbConnect.DatabaseConnect;
import org.example.bookmanagement.model.Book;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = new ArrayList<>();

        try (Connection connection = DatabaseConnect.getCon()) {
            String query = "SELECT * FROM book";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");
                String publisher = resultSet.getString("publisher");
                String description = resultSet.getString("description");
                String imgUrl = resultSet.getString("img_url");
                String condition = resultSet.getString("condition");
                boolean borrowed = resultSet.getBoolean("borrow_status");

                bookList.add(new Book(id, isbn, name, publisher, description, imgUrl, condition, borrowed))
            }

            request.setAttribute("bookList", bookList);

            RequestDispatcher view = request.getRequestDispatcher("book/list.jsp");
            view.forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
