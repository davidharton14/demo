package com.example.demo;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private LocalDate birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
