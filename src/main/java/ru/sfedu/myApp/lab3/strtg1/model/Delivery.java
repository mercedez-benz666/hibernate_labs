package ru.sfedu.myApp.lab3.strtg1.model;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
