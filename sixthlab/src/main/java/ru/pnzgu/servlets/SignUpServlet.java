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
import java.time.LocalDate;

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
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        User user = new User(userName, password, birthDate, name, surname);
        usersRepository.save(user);
        doGet(req, resp);
    }
}
