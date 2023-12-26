package dev.repository;

import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sakibul.domain.Student;

import java.sql.*;
import java.util.List;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void edit(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        User user = get(id);
        session.delete(user);
    }

    public List<User> getAll() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
