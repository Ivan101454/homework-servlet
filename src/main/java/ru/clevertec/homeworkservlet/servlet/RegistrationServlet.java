package ru.clevertec.homeworkservlet.servlet;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.clevertec.homeworkservlet.utils.JspHelper;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.setAttribute("roles", List.of("USER, ADMIN", "USER"));
    request.getRequestDispatcher(JspHelper.getPath("registration"))
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("name");
    }

    public void destroy() {
    }
}