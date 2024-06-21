package com.annette.spring.project_stars.service;

import java.util.List;

import com.annette.spring.project_stars.entity.User;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public User saveUser(User user);

    public void deleteUser(int id);

}
