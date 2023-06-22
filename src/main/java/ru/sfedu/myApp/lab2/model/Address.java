package ru.sfedu.myApp.lab2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
@Embeddable
@Table(name="Address")
public class Address {
    @Column(name="user_country")
    private String country;
    @Column(name="user_city")
    private String city;
    @Column(name="user_street")
    private String street;
    @Column(name="user_number")
    private int number;
    public Address(String country,String city, String street, int number){
        this.country=country;
        this.city=city;
        this.street=street;
        this.number=number;
    }
    public Address(){
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
