package com.annette.spring.project_stars.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        List<User> users = entityManager.createQuery("from User", User.class)
            .getResultList();
        
        return users;

    }

    @Override
    public User getUser(int id) {

        User user = entityManager.find(User.class, id);

        return user;

    }

    @Override
    public User saveUser(User user) {

        User newUser = entityManager.merge(user);

        user.setId(newUser.getId());

        return user;

    }

    @Override
    public void deleteUser(int id) {

        User user = entityManager.find(User.class, id);

        entityManager.remove(user);

    }

}
