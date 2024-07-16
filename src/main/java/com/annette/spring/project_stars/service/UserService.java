package com.annette.spring.project_stars.service;

import java.util.List;

import com.annette.spring.project_stars.entity.Settings;
import com.annette.spring.project_stars.entity.User;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public Settings getUserSettings(int id);

    public void purchaseStar(String purchaseInf);

    public User addUser(User user);

    public User updateUser(User user);

    public User refillBalance(int id, String balance);

    public void deleteUser(int id);

}
