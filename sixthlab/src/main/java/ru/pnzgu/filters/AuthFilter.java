package ru.pnzgu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 28.09.2019
 * AuthFilter
 *
 * @author havlong
 * @version 1.0
 */
@WebFilter("/home")
public class AuthFilter implements Filter {

    /**
     * Фильтр позволяет защитить сервлет HomeServlet от незарегистрированных пользователей
     * @param servletRequest the <code>ServletRequest</code> object contains the client's request
     * @param servletResponse the <code>ServletResponse</code> object contains the filter's response
     * @param filterChain the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException if an I/O related error has occurred during the processing
     * @throws ServletException if an exception occurs that interferes with the
     *                          filter's normal operation
     * @see ru.pnzgu.servlets.HomeServlet
     * @see UnavailableException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if ((session == null || session.getAttribute("user") == null)) {
            servletRequest.getServletContext().getRequestDispatcher("/").forward(request, response);
        }
        filterChain.doFilter(request, response);
    }
}
