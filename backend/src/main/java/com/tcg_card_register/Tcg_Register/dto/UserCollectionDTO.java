package com.tcg_card_register.Tcg_Register.dto;

import java.util.List;
import java.util.UUID;

public class UserCollectionDTO {
    private String collectionName;
    private long collectionId;
    private long userId;
    private long cardTotal;
    private int status;
    private List<CardCollectionDTO> cards;

    public UserCollectionDTO(String collectionName, long collectionId, long userId, long cardTotal, int status, List<CardCollectionDTO> cards) {
        this.collectionName = collectionName;
        this.collectionId = collectionId;
        this.userId = userId;
        this.cardTotal = cardTotal;
        this.status = status;
        this.cards = cards;
    }

    public long getUserId() {
        return userId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Long getCardTotal() {
        return cardTotal;
    }

    public List<CardCollectionDTO> getCards() {
        return cards;
    }

    public void setCardTotal(long cardTotal) {
        this.cardTotal = cardTotal;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public void setCards(List<CardCollectionDTO> cards) {
        this.cards = cards;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
