package ru.sfedu.myApp.lab4.model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name="storage")
public class Storage extends Action {
@Column(name="height")
    private int height;
    @Column(name="width")
    private int width;
    @Column(name="length")
    private int length;



    public Storage(int height, int width, int length) {
        this.height=height;
        this.width=width;
        this.length=length;

    }
    public Storage(){
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
