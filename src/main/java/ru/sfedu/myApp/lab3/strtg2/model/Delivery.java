package ru.sfedu.myApp.lab3.strtg2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="delivery")
public class Delivery extends Action {
@Column(name="distance")
    private double distance;
    @Column(name="height")

    private int height;
    @Column(name="width")

    private int width;
    @Column(name="length")

    private int length;
    public Delivery(){
    }

    public Delivery(int height,int width, int length,double distance) {
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

}
