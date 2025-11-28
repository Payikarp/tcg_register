package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="illustrator")
public class IllustratorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int status;

    @Autowired
    public IllustratorModel() {
    }

    public IllustratorModel(long id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
