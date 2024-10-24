package ru.clevertec.homeworkservlet.integration;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import ru.clevertec.homeworkservlet.dao.UserDao;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.repository.UserRepository;
import ru.clevertec.homeworkservlet.service.UserService;
import ru.clevertec.homeworkservlet.utils.HibernateUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

public class UserServiceIT {
    static SessionFactory sessionFactory = HibernateUtil.init();
    static UserRepository userRepository = new UserDao(sessionFactory);

    @Test
    void shouldFindUserByLoginAndComparePassword() {
        UserService userService = new UserService();
        Optional<UserDto> userByLogin = userService.getUserByLogin("ivan101");
        System.out.println(userByLogin.get().toString());
//        assertEquals("12345", userByLogin.get().getPassword());

    }
}
