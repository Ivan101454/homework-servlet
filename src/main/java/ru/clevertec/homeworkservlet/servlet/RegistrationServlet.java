package ru.clevertec.homeworkservlet.servlet;

import java.io.*;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.enums.Role;
import ru.clevertec.homeworkservlet.mapper.UserMapper;
import ru.clevertec.homeworkservlet.service.UserService;
import ru.clevertec.homeworkservlet.utils.JspHelper;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();
    public void init() {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    req.setAttribute("roles", List.of(Role.values()));
    req.getRequestDispatcher(JspHelper.getPath("registration"))
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto newUser = UserDto.builder().name(req.getParameter("name"))
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .address(req.getParameter("address"))
                .age(Integer.parseInt(req.getParameter("age")))
                .role(Role.valueOf(req.getParameter("role")))
                .build();
        userService.createUser(newUser);
        resp.sendRedirect("/login");
    }

    public void destroy() {
    }
}