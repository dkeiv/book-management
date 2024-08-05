package org.example.bookmanagement.model;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String course;
    private Date birthday;
    private boolean active = true;


    // for update
    public User() {
    }

    public User(String name, String course, Date birthday, boolean active) {
        this.name = name;
        this.course = course;
        this.birthday = birthday;
        this.active = active;
    }

    public User(int id, String name, String course, Date birthday, boolean active) {
        this(name, course, birthday, active);
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
