package ru.pnzgu.servlets;

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
 * HomeServlet
 *
 * @author havlong
 * @version 1.0
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        usersRepository = new UsersRepositoryJsonImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersFromServer", usersRepository.findAll());
        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}
