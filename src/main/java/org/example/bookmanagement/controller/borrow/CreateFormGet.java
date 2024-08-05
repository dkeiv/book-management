package org.example.bookmanagement.controller.borrow;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/borrow-book-form")
public class CreateFormGet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("borrow/create.jsp");
        rd.forward(request, response);
    }
}
