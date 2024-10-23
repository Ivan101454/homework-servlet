package ru.clevertec.homeworkservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.service.UserService;
import ru.clevertec.homeworkservlet.utils.JspHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<UserDto> userByLogin = userService.getUserByLogin(login);
        if(userByLogin.isPresent() && userByLogin.get().getPassword().equals(password)) {
            req.getSession().setAttribute("user", userByLogin.get());
            resp.sendRedirect("/list");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
