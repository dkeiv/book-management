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

@WebServlet(value = "/edit-borrow-form")
public class EditFormGet extends HttpServlet {
    BookDAOInterface bookDAO = new BookDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int borrowId = Integer.parseInt(request.getParameter("borrowId"));

        try {
            BorrowBook borrowBook = bookDAO.getBorrowBookById(borrowId);
            request.setAttribute("borrowBook", borrowBook);

            List<BorrowBook.Status> statusList = bookDAO.getBorrowedStatus();
            request.setAttribute("statusList", statusList);

            RequestDispatcher rd = request.getRequestDispatcher("borrow/edit.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
