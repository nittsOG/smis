package com.manage.faculty.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "fname")
    private String username;

    @Column(name = "password")
    private String password;

    // Other fields as needed (e.g., name, email)

    // Constructors, getters, and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
