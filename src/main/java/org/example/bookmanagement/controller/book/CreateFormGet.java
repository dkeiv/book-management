package org.example.bookmanagement.controller.book;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet(value = "/create-book-form")
public class CreateFormGet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
