package ru.sfedu.myApp.lab3.strtg4.model;

import com.sun.istack.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity(name = "storage")
@Table(name = "storage")
public class Storage extends Action {
    @Column(name = "height")
    @NotNull
    private int height;
    @Column(name = "width")
    @NotNull
    private int width;
    @Column(name = "length")
    @NotNull
    private int length;


    public Storage(int height, int width, int length, String actionType, String country, int numberAction, boolean insurance) {
        super(insurance, country, actionType, numberAction);
        this.height = height;
        this.width = width;
        this.length = length;

    }

    public Storage() {
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
