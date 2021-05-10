package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "kursach")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "roles")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "cities")
    private String cities;


    public User() {
    }

    public User(String login, String password, String email, Role role, String cities) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.cities = cities;
    }

    public User(String login, String password, String email, Role role, Status status) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public String getCities() {
        return cities;
    }


    public void setCities(String cities) {
        this.cities = cities;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
