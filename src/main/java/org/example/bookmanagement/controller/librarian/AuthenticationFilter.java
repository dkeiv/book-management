package org.example.bookmanagement.controller.librarian;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/list-librarian", "/list-user/*", "/list-category/*","/list-borrow/*",
        "/borrow-book-form/*","/delete-borrow-form/*","/edit-borrow-form/*",
        "/create-category-form/*","/delete-category-form/*","/edit-category-form/*",
        "/create-librarian-form/*","/delete-librarian-form/*","/edit-librarian-form/*",
        "/create-user-form/*","/delete-user-form/*","/edit-user-form/*"
}) // Correctly specify URL patterns
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is logged in
        if (httpRequest.getSession().getAttribute("librarian") != null) {
            // User is logged in, continue with the request
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
