package ru.sfedu.myApp.entity;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.xml.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name = "name")
    @CsvBindByPosition(position = 0)
    private String name;
    @XmlElement(name = "address")
    @CsvBindByPosition(position = 1)
    private String address;
    @XmlElement(name = "userType")
    @CsvBindByPosition(position = 2)
    private String userType;
    @XmlElement(name = "userId")
    @CsvBindByPosition(position = 3)
    private String id;
    @XmlTransient
    private String userActions = getUserActions();

    public User(){
    }
    public User(String name, String address, String userType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.userType = userType;
    }
    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }

    public String getUserActions() {
        return userActions;
    }

    public void setUserActions(String userActions) {
        this.userActions = userActions;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name == user.name && id.equals(user.id) && address.equals(user.address) && userType.equals(user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address,userType, userActions);
    }

}
