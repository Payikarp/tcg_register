package com.tcg_card_register.Tcg_Register.dto;

public class CardCollectionDTO {
    private long card;
    private long cardAmount;

    public CardCollectionDTO(long card, long cardAmount) {
        this.card = card;
        this.cardAmount = cardAmount;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public long getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(long cardAmount) {
        this.cardAmount = cardAmount;
    }
}
