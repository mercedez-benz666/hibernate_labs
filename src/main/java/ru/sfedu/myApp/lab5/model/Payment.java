package ru.sfedu.myApp.lab5.model;

import jakarta.persistence.*;

@Entity
@Table(name="payment")
public class Payment extends Action {

@Column(name="money")
    private double money;



    public Payment(){
    }
    public Payment(double money,String actionType, String country, int numberAction) {

        this.money = money;
    }
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }





}
