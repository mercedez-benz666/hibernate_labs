package ru.sfedu.myApp.lab3.strtg1.model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@MappedSuperclass
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
