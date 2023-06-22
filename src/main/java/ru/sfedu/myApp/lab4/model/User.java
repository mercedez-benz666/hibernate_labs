package ru.sfedu.myApp.lab4.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Entity
@Table(name = "user")
public class User {
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="USER_ID")
    private String id;

    @Column(name = "address", nullable = true)
    public String address;
    @ElementCollection
    @OrderColumn
    @Column(name = "numbers", nullable = true)
    @CollectionTable(name="list")
    private List<Integer> cars=new ArrayList<>();


    @ElementCollection
    @MapKeyColumn(name = "brand")
    @Column(name = "model")
    @CollectionTable(name = "map", joinColumns = @JoinColumn(name = "USER_ID"))
    private Map<String, String> myMap = new HashMap<>();



    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public List<Integer> getCars() {
        return cars;
    }

    public void setCars(List<Integer> cars) {
        this.cars = cars;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addCars(int car){
        cars.add(car);
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
}
