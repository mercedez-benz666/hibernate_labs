package ru.sfedu.myApp.lab3.strtg2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="action")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Action{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
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
