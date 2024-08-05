package org.example.bookmanagement.controller.librarian;

import org.example.bookmanagement.model.Librarian;
import org.example.bookmanagement.service.ILibrarianDAO;
import org.example.bookmanagement.service.LibrarianDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/delete-librarian")

public class DeleteFormGet extends HttpServlet {
    private static final ILibrarianDAO librarianDAO =new LibrarianDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        // Thực hiện xóa trước
        librarianDAO.deleteLibrarian(id);

        // Cập nhật danh sách thư viện
        List<Librarian> librarianList = librarianDAO.showAllLibrarian();
        req.setAttribute("librarianList", librarianList);

        // Chuyển tiếp đến trang hiển thị danh sách thư viện
        RequestDispatcher dispatcher = req.getRequestDispatcher("librarian/list.jsp");
        dispatcher.forward(req, resp);
    }
}