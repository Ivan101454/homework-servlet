package ru.clevertec.homeworkservlet.repository;

import ru.clevertec.homeworkservlet.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User create(User user);
    void delete(Long userId);
    User update(User user);
    Optional<User> findById(Long userId);
    List<User> findAllUsers();
}
