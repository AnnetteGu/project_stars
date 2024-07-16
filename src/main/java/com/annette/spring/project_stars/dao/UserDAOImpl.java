package com.annette.spring.project_stars.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.annette.spring.project_stars.entity.Settings;
import com.annette.spring.project_stars.entity.Star;
import com.annette.spring.project_stars.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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

    @SuppressWarnings("unchecked")
    @Override
    public Optional<User> getUserByLogin(String login) {
        
        ObjectMapper objectMapper = new ObjectMapper();

        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        try {
            resultMap = objectMapper.readValue(login, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String userLogin = resultMap.get("login");

        Query query = entityManager
            .createQuery("from User where login =:userLogin");
        
        query.setParameter("userLogin", userLogin);

        return (Optional<User>) query.getSingleResult();

    }

    @Override
    public Settings getUserSettings(int id) {

        User user = entityManager.find(User.class, id);

        Settings userSettings = user.getUserSettings();

        int settingsId = userSettings.getId();

        return entityManager.find(Settings.class, settingsId);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void purchaseStar(String purchaseInf) {

        ObjectMapper objectMapper = new ObjectMapper();

        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        try {
            resultMap = objectMapper.readValue(purchaseInf, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int starId = Integer.parseInt(resultMap.get("starId"));
        int userId = Integer.parseInt(resultMap.get("userId"));

        Star star = entityManager.find(Star.class, starId);
        User user = entityManager.find(User.class, userId);

        user.setBalance(user.getBalance() - star.getPrice());

        star.setKeeperId(userId);

        entityManager.merge(user);
        entityManager.merge(star);

    }

    @Override
    public User addUser(User user) {

        Settings settings = new Settings("day", "russian");

        user.setUserSettings(settings);

        User newUser = entityManager.merge(user);

        user.setId(newUser.getId());

        settings.setId(newUser.getUserSettings().getId());

        user.setUserSettings(settings);

        return user;

    }

    @Override
    public User updateUser(User user) {

        User newUser = entityManager.merge(user);

        user.setId(newUser.getId());

        return user;

    }

    @SuppressWarnings("unchecked")
    @Override
    public User refillBalance(int id, String balance) {
        
        ObjectMapper objectMapper = new ObjectMapper();

        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        try {
            resultMap = objectMapper.readValue(balance, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        double newBalance = Double.parseDouble(resultMap.get("balance"));
        
        User user = entityManager.find(User.class, id);

        user.setBalance(user.getBalance() + newBalance);

        return entityManager.merge(user);

    }

    @Override
    public void deleteUser(int id) {

        User user = entityManager.find(User.class, id);

        entityManager.remove(user);

    }

}
