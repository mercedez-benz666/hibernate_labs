package ru.sfedu.myApp.lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Action{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public Action() {
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
