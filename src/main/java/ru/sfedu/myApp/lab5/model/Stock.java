package ru.sfedu.myApp.lab5.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="stocks")
public class Stock {
    @Column(name="address")
    private String address;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "stocks")
    private Set<Delivery> stocks = new HashSet<>();


    public Stock(String address) {
        this.address = address;
    }

    public Stock() {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Delivery> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Delivery> stocks) {
        this.stocks = stocks;
    }
}
