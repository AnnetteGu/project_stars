package com.annette.spring.project_stars.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.annette.spring.project_stars.dao.UserDAO;
import com.annette.spring.project_stars.entity.User;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> user = userDAO.getUserByLogin(username);

        return user.map(MyUserDetails::new)
            .orElseThrow();

    }

}
