package com.example.android_node.models;

import android.database.DatabaseErrorHandler;

import java.util.Date;
import java.util.List;

public class Activity {
    private String admin;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int maxParticipant;
    private List<User> participants;

    public Activity(String admin, String name, String description, Date startDate, Date endDate, int maxParticipant) {
        this.admin = admin;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxParticipant = maxParticipant;
    }

    public static List<Activity> getAllActivities(){
        //get all activities from database
        return null;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
