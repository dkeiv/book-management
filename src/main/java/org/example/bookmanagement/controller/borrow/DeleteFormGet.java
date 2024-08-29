package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/delete-borrow-form")
public class DeleteFormGet  extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int borrowId = Integer.parseInt(request.getParameter("borrowId"));
            request.setAttribute("borrowId", borrowId);

            BorrowBook borrowBook = bookDAO.getBorrowBookById(borrowId);
            request.setAttribute("borrowBook", borrowBook);

            List<BorrowBook.Status> statusList = bookDAO.getBorrowedStatus();
            request.setAttribute("statusList", statusList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("borrow/delete.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
