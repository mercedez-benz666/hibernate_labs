package ru.sfedu.myApp.lab4.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@MappedSuperclass
public class Action{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="ID")
    private String id;
    @ElementCollection
    @Column(name="addresses")
    public Set<String> addresses = new HashSet<>();


    public Action() {
    }


    public Set<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void addAddress(String address) throws Exception {
        addresses.add(address);
    }


}
