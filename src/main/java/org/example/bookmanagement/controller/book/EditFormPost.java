package org.example.bookmanagement.controller.book;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/edit-book")
public class EditFormPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("bookId"));
        String name = request.getParameter("bookId");
        String condition = request.getParameter("bookCondition");
        String publisher = request.getParameter("bookPublisher");
        String bookImage = request.getParameter("bookImage");
        String description = request.getParameter("bookDescription");
        String borrowedStatus = request.getParameter("bookBorrowedStatus");
        String [] bookCategory = request.getParameterValues("bookCategory");

    }
}
