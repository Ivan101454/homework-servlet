package ru.clevertec.homeworkservlet.servlet;

import java.io.*;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.clevertec.homeworkservlet.utils.JspHelper;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    req.setAttribute("roles", List.of("USER", "ADMIN", "USER"));
    req.getRequestDispatcher(JspHelper.getPath("registration"))
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("name");
    }

    public void destroy() {
    }
}