package org.example.bookmanagement.controller.borrow;

import org.example.bookmanagement.model.BorrowBook;
import org.example.bookmanagement.service.bookDAO.BookDAO;
import org.example.bookmanagement.service.bookDAO.BookDAOInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/delete-borrow")
public class DeleteFormPost extends HttpServlet {
    private final BookDAOInterface bookDAO = new BookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int borrowId = Integer.parseInt(request.getParameter("borrowId"));
            BorrowBook borrowBook = bookDAO.getBorrowBookById(borrowId);

            if (borrowBook.getStatus().equals(BorrowBook.Status.RETURNED.getDescription())) {
                bookDAO.deleteBorrowBook(borrowId);
                response.sendRedirect("success.jsp");
                return;
            }

            request.setAttribute("message", "Book is being borrowed");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
