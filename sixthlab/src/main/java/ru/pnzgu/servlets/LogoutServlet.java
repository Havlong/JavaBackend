package ru.pnzgu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 07/12/2019
 * LogoutServlet
 *
 * Сервлет, деавторизующий пользователя
 *
 * @author havlong
 * @version 1.0
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession() != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", null);
            resp.sendRedirect("/");
        }
    }
}
