package ru.sfedu.myApp.lab2.model;


import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "test_name")
    private String name;

    @Column(name = "test_description")
    private String description;
    @Column(name = "dateCreated")
    private Date dateCreated;
    @Column(name = "test_check")
    private boolean check;
    public User(String name, String description, Date dateCreated, boolean check){
        this.name=name;
        this.description=description;
        this.dateCreated=dateCreated;
        this.check=check;
    }
    public User(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
