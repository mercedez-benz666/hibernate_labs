package ru.sfedu.myApp.lab3.strtg4.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="action")
@Inheritance(strategy = InheritanceType.JOINED)
public class Action{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    private String id;
    @Column(name="actionType")
    private String actionType;
    @Column(name="country")
    private String country;
    @Column(name="numberAction")
    private int numberAction;
    @Column(name="insurance")
    private boolean insurance;

    public Action(boolean insurance, String country, String actionType, int numberAction) {
        this.insurance=insurance;
        this.country=country;
        this.actionType=actionType;
        this.numberAction=numberAction;
    }

    public Action() {
    }

    public boolean getInsurance() {
        return insurance;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberAction() {
        return numberAction;
    }

    public void setNumberAction(int numberAction) {
        this.numberAction = numberAction;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
