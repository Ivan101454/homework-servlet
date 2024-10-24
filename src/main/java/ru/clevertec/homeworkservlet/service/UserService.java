package ru.clevertec.homeworkservlet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.homeworkservlet.dao.UserDao;
import ru.clevertec.homeworkservlet.dto.UserDto;
import ru.clevertec.homeworkservlet.entities.User;
import ru.clevertec.homeworkservlet.mapper.UserMapper;
import ru.clevertec.homeworkservlet.repository.UserRepository;
import ru.clevertec.homeworkservlet.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final static SessionFactory sessionFactory = HibernateUtil.init();
    private final static UserRepository userRepository = new UserDao(sessionFactory);


    public List<UserDto> getAllUsers() {
        return userRepository.findAllUsers().stream().map(UserMapper.INSTANCE::userToUserDto).toList();
    }

    public Optional<UserDto> getUserByLogin(String login) {
        Optional<UserDto> userDto = userRepository.findByLogin(login).map(UserMapper.INSTANCE::userToUserDto);
        return userDto;
    }
}
