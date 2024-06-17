package com.annette.spring.project_stars.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "balance")
    private double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "settings_id")
    Settings userSettings;

    @OneToMany(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
    }, mappedBy = "userKeeper")
    Star userStar;

    @OneToMany(cascade = {
        CascadeType.DETACH,
        CascadeType.MERGE,
        CascadeType.PERSIST,
        CascadeType.REFRESH
    }, mappedBy = "author")
    Comment userComment;

    public User() {
    }

    public User(String nickname, String login, String email, String password, String role, double balance) {
        this.nickname = nickname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Settings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(Settings userSettings) {
        this.userSettings = userSettings;
    }

    public Star getUserStar() {
        return userStar;
    }

    public void setUserStar(Star userStar) {
        this.userStar = userStar;
    }

    public Comment getUserComment() {
        return userComment;
    }

    public void setUserComment(Comment userComment) {
        this.userComment = userComment;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nickname=" + nickname + ", login=" + login + ", email=" + email + ", password="
                + password + ", role=" + role + ", balance=" + balance + ", userSettings=" + userSettings
                + ", userStar=" + userStar + ", userComment=" + userComment + "]";
    }

}