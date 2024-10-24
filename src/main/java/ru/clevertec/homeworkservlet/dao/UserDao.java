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
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(Long userId) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, userId);
        if (user != null) {
            session.remove(user);
        }
        session.getTransaction().commit();
    }

    @Override
    public User update(User user) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public Optional<User> findById(Long userId) {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<User> user = Optional.ofNullable(session.get(User.class, userId));
        session.getTransaction().commit();
        return user;
    }

    public Optional<User> findByLogin(String login) {
        @Cleanup var session = sessionFactory.openSession();
//        session.beginTransaction();
//        Optional<User> user = Optional.ofNullable(session.get(User.class, login));
        //        session.getTransaction().commit();
        return Optional.ofNullable(session.createQuery("select u from User u where u.login = login", User.class).getResultList().getFirst());
    }

    @Override
    public List<User> findAllUsers() {
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        session.getTransaction().commit();
        return users;
    }
}
