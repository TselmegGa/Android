package com.example.android_node.models;

import java.util.ArrayList;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private  String place;

    public User(String firstname, String lastname, String email, String password, String place) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.place = place;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void create() {
        // must insert in the databases
    }

}
