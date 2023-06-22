package ru.sfedu.myApp.lab5.model;

import jakarta.persistence.*;
import ru.sfedu.myApp.lab5.model.Action;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="deliveries")
public class Delivery extends Action {
@Column(name="distance")
    private double distance;
    @Column(name="height")

    private int height;
    @Column(name="width")

    private int width;
    @Column(name="length")

    private int length;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "deliveries_stocks",
            joinColumns = {@JoinColumn(name = "stock_id")},
            inverseJoinColumns = {@JoinColumn(name = "delivery_id")})
    private Set<Stock> stocks = new HashSet<>();

    public Delivery(){
    }

    public Delivery(int height, int width, int length, double distance) {
        this.height=height;
        this.width=width;
        this.length=length;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
    public void addStock(Stock stock){
        stocks.add(stock);
    }
}
