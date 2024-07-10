package com.annette.spring.project_stars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annette.spring.project_stars.entity.Settings;
import com.annette.spring.project_stars.entity.User;
import com.annette.spring.project_stars.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
        
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") int id) {

        return userService.getUser(id);

    }

    @GetMapping("/users/settings/{id}")
    public Settings getUserSettings(@PathVariable(name = "id") int id) {

        return userService.getUserSettings(id);
        
    }

    @PutMapping("/users/purchase-star")
    public String purchaseStar(@RequestBody String purchaseInf) {

        userService.purchaseStar(purchaseInf);

        return "Star was successfully purchased";

    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        userService.saveUser(user);

        return user;

    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.saveUser(user);

        return user;

    }

    @PutMapping("/users/{id}")
    public User refillBalance(@PathVariable(name = "id") int id, 
        @RequestBody String balance) {

        return userService.refillBalance(id, balance);

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {

        userService.deleteUser(id);

        return "User with id = " + id + " was deleted";

    }

}
