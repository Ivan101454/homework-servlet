package ru.clevertec.homeworkservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.clevertec.homeworkservlet.service.UserService;
import ru.clevertec.homeworkservlet.utils.JspHelper;

import java.io.IOException;

@WebServlet("/list")
public class ListUsersServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers());
        req.getRequestDispatcher(JspHelper.getPath("list")).forward(req,resp);
    }
}
