package ru.clevertec.homeworkservlet.integration;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.homeworkservlet.dao.UserDao;
import ru.clevertec.homeworkservlet.entities.User;
import ru.clevertec.homeworkservlet.enums.Role;
import ru.clevertec.homeworkservlet.repository.UserRepository;
import ru.clevertec.homeworkservlet.utils.HibernateUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoIT {
    static SessionFactory sessionFactory;
    static UserRepository userRepository;
    @BeforeAll
    static void initSession() {
        sessionFactory = HibernateUtil.init();
        userRepository = new UserDao(sessionFactory);
    }

    @Test
    void shouldCreateNewUser() {
        //given
        User user = User.builder().name("Ivan").age(37).address("Minsk").login("ivan101").password("12345")
                .build();
        //when
        User userPersiste = userRepository.create(user);
        //then
        assertEquals("ivan101", userPersiste.getLogin());
    }

    @Test
    void shouldUpdateFieldsUser() {
        //given
        User user = User.builder().id(1L).name("Ivan").age(37).address("Minsk").login("ivan101").password("12345")
                .role(Role.ADMIN).build();

        //when
        User updateUser = userRepository.update(user);

        //then
        assertEquals(Role.ADMIN, updateUser.getRole());

    }
    @Test
    void shouldFindUserByLogin() {
        //given
        String login = "ivan101";

        //when
        Optional<User> user = userRepository.findByLogin(login);

        //then
        assertEquals("12345", user.get().getPassword());

    }


}
