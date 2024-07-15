package com.annette.spring.project_stars.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.annette.spring.project_stars.entity.User;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.stream(user.getRole().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        
    }

    @Override
    public String getPassword() {

        return user.getPassword();
        
    }

    @Override
    public String getUsername() {

        return user.getLogin();
        
    }

}
