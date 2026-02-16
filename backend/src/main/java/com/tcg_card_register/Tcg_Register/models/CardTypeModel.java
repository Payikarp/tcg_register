package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="card_type")
public class CardTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private int status;

    @Autowired
    public CardTypeModel() {
    }

    public CardTypeModel(long id, String type, int status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
