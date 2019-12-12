package ru.pnzgu.servlets;

import ru.pnzgu.models.User;
import ru.pnzgu.repositories.UsersRepository;
import ru.pnzgu.repositories.UsersRepositoryJsonImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 28.09.2019
 * SignUpServlet
 *
 * @author havlong
 * @version 1.0
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        usersRepository = new UsersRepositoryJsonImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String name = req.getParameter("firstName");
        String surname = req.getParameter("lastName");
        String car = req.getParameter("car");
        if (usersRepository.exists(userName)) {
            req.setAttribute("error", true);
            req.setAttribute("alert", "Пользователь с этим логином уже существует");
            doGet(req, resp);
        } else {
            User user = new User(userName, password, name, surname, car);
            usersRepository.save(user);
            resp.sendRedirect("/");
        }
    }
}
