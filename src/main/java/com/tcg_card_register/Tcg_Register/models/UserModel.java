package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name ="users")
public class UserModel {
    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String email;
    private String password;
    private int type;
    private int status;

    @Autowired
    public  UserModel(){}

    public UserModel(String username, String email, String password, int type, int status)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
