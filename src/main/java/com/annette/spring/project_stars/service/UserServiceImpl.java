package com.annette.spring.project_stars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annette.spring.project_stars.dao.UserDAO;
import com.annette.spring.project_stars.entity.Settings;
import com.annette.spring.project_stars.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();

    }

    @Override
    @Transactional
    public User getUser(int id) {

        return userDAO.getUser(id);

    }

    @Override
    @Transactional
    public Settings getUserSettings(int id) {

        return userDAO.getUserSettings(id);

    }

    @Override
    @Transactional
    public void purchaseStar(String purchaseInf) {

        userDAO.purchaseStar(purchaseInf);

    }

    @Override
    @Transactional
    public User addUser(User user) {

        userDAO.addUser(user);

        return user;

    }

    @Override
    @Transactional
    public User updateUser(User user) {
        
        userDAO.updateUser(user);

        return user;

    }

    @Override
    @Transactional
    public User refillBalance(int id, String balance) {

        return userDAO.refillBalance(id, balance);

    }

    @Override
    @Transactional
    public void deleteUser(int id) {

        userDAO.deleteUser(id);

    }

}
