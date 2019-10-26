package ru.pnzgu.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 13.09.2019
 * JspServlet
 *
 * Сервлет, который нужен для регистрации времени, посещений и перенаправления на JSP
 * Перехватывает GET-запросы на /jsp
 *
 * @author havlong
 * @version 1.0
 */
@WebServlet("/jsp")
public class JspServlet extends HttpServlet {
    /**
     * Перенаправляет на index.jsp
     * Записывает в атрибут serverTime дату и время, а в атрибут visitsCount данные счётчика
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date time = Calendar.getInstance().getTime();
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(time);
        req.setAttribute("serverTime", date);
        req.setAttribute("visitsCount", addVisit());
        req.getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }

    /**
     * Функция, которая регистрирует пользователя, добавляя его к счётчику
     * Количество посещений хранится в файле count.txt
     * @return количество посещений
     */
    private int addVisit() {
        int count;
        if (new File("count.txt").exists()) {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader("count.txt"))
            ) { // Если файл существует, используем Java 7 try-with-resources для того, чтобы получить данные счётчика
                count = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                // Считаем, что до этого посещений не было
                count = 0;
                e.printStackTrace();
            }
        } else { // Никого ещё не было
            count = 0;
        }
        try (
                PrintWriter writer = new PrintWriter(new FileWriter("count.txt"))
        ) { // Используем Java 7 try-with-resources для того, чтобы записать увеличенный счётчик
            writer.println(++count);
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; // Если нет прав на запись, не можем регистрировать посещения
    }
}
