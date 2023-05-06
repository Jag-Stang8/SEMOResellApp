package com.redacted.semoresellapp.model;

import jakarta.persistence.*;

import java.util.Objects;

/*
 * This class implements the User entity with the attributes:
 * userID, email, password, buyRate, and sellRate
 * as well as the appropriate getters and setters
 */
@Entity
@Table(name = "customer_table")
public class User {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    //Constructors
    public User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    //Methods


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    //To-String, Equals, and HashCode
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}


