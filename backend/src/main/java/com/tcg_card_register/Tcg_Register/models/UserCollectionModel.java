package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="user_collection")
public class UserCollectionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String collectionName;

    private long userId;
    private long totalCards;
    private int status;

    @Autowired
    public UserCollectionModel() {
    }

    public UserCollectionModel(long id, String collectionName, long user_id, long totalCards, int status) {
        this.id = id;
        this.collectionName = collectionName;
        this.userId = user_id;
        this.totalCards = totalCards;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public long getUserId() {
        return userId;
    }

    public long getTotalCards() {
        return totalCards;
    }

    public int getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTotalCards(long totalCards) {
        this.totalCards = totalCards;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
