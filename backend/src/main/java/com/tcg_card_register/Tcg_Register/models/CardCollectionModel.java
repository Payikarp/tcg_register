package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Entity
@Table(name = "card_collection")
public class CardCollectionModel {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private UserCollectionModel collectionId;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CardsModel cardId;

    private long cardTotal;

    @Autowired
    public CardCollectionModel() {
    }

    public CardCollectionModel(UUID id, UserCollectionModel collectionId, CardsModel cardId, long cardTotal) {
        this.id = id;
        this.collectionId = collectionId;
        this.cardId = cardId;
        this.cardTotal = cardTotal;
    }

    public CardCollectionModel(UserCollectionModel collectionId, CardsModel cardId, long cardTotal) {
        this.collectionId = collectionId;
        this.cardId = cardId;
        this.cardTotal = cardTotal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserCollectionModel getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(UserCollectionModel collection_id) {
        this.collectionId = collection_id;
    }

    public CardsModel getCardId() {
        return cardId;
    }

    public void setCardId(CardsModel card_id) {
        this.cardId = card_id;
    }

    public long getCardTotal() {
        return cardTotal;
    }

    public void setCardTotal(long cardTotal) {
        this.cardTotal = cardTotal;
    }
}
