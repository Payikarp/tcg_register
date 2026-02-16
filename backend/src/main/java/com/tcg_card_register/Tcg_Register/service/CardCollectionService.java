package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CardCollectionService {

    public List<CardCollectionModel> getCardsFromCollection(Long id);

    //public CardsModel getCardFromCollection(UserCollectionModel collectionId, CardsModel cardId);

    public boolean insertCardsToCollection(UserCollectionDTO collection);

    public boolean updateCardsFromCollection(UserCollectionDTO collection);

    public CardsModel deleteCardFromCollection(UUID id, Long card_id);

    public CardCollectionModel findCollection(long collection);
}
