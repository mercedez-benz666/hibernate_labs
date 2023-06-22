package ru.sfedu.myApp.lab3.strtg2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
