package com.example.android_node.models;

import java.util.ArrayList;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String place;

    public User() {

    }

    public User(String firstname, String lastname, String email, String place) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
