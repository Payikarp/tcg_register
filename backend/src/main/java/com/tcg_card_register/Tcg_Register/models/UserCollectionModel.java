package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="user_collection")
public class UserCollectionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String collection_name;

    private long userId;
    private long totalCards;
    private int status;

    @Autowired
    public UserCollectionModel() {
    }

    public UserCollectionModel(long id, String collection_name, long user_id, long totalCards, int status) {
        this.id = id;
        this.collection_name = collection_name;
        this.userId = user_id;
        this.totalCards = totalCards;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getCollection_name() {
        return collection_name;
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

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
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
