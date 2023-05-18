package com.mcfly.crud_rest_demo.dao;

import com.mcfly.crud_rest_demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String userName) {
        final TypedQuery<User> query = entityManager.createQuery("from User where userName=:uName", User.class);
        query.setParameter("uName", userName);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception ignored) {
        }
        return user;
    }
}
