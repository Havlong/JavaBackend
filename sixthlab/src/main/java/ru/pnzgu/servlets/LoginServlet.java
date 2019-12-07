package ru.pnzgu.servlets;

import ru.pnzgu.repositories.UsersRepository;
import ru.pnzgu.repositories.UsersRepositoryJsonImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 28.09.2019
 * LoginServlet
 *
 * @author havlong
 * @version 1.0
 */
@WebServlet("/")
public class LoginServlet extends HttpServlet {
    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UsersRepositoryJsonImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("login");
        String password = req.getParameter("password");

        if (usersRepository.exists(userName, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userName);
            resp.sendRedirect("/home");
        } else {
            req.setAttribute("error", true);
            doGet(req, resp);
        }
    }
}
