package ru.clevertec.homeworkservlet.dao;

import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.clevertec.homeworkservlet.entities.User;
import ru.clevertec.homeworkservlet.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class UserDao implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        @Cleanup var session = sessionFactory.openSession();
        session.persist(user);
        return user;
    }

    @Override
    public void delete(Long userId) {
        @Cleanup var session = sessionFactory.openSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            session.remove(user);
        }
    }

    @Override
    public User update(User user) {
        @Cleanup var session = sessionFactory.openSession();
        session.merge(user);

        return null;
    }

    @Override
    public Optional<User> findById(Long userId) {
        @Cleanup var session = sessionFactory.openSession();
        return Optional.ofNullable(session.get(User.class, userId));
    }

    @Override
    public List<User> findAllUsers() {
        @Cleanup var session = sessionFactory.openSession();
        return session.createQuery("select u from User u", User.class).getResultList();
    }
}