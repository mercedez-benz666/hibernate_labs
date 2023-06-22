package ru.sfedu.myApp.lab3.strtg2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User {
@Column(name="name")
    private String name;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    public User(){
    }
    public User(String name, String address, String userType) {
        this.name = name;
    }
    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }



}
