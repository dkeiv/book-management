package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/borrow-book-form")
public class CreateFormGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BorrowBook.Status> statusList = bookDAO.getBorrowedStatus();
            request.setAttribute("statusList", statusList);

            RequestDispatcher rd = request.getRequestDispatcher("borrow/create.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
