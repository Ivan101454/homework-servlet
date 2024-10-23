package ru.clevertec.homeworkservlet.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.clevertec.homeworkservlet.dto.UserDto;

import java.io.IOException;
import java.util.Set;
@WebFilter("/list")
public class AuthorizationFilter implements Filter {

    private final static Set<String> EXIST_PATH = Set.of("/registration", "/login", "/list");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if(isExistPath(requestURI) || isUserLogged(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            var referer = ((HttpServletRequest) servletRequest).getHeader("referer");
            ((HttpServletResponse) servletResponse).sendRedirect(referer != null ? referer : "/login");
        }
    }

    public boolean isUserLogged(ServletRequest servletRequest) {
        UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }


    public boolean isExistPath(String uri) {
        return EXIST_PATH.stream().anyMatch(uri::startsWith);
    }

}
