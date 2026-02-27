package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.dto.CardCollectionDTO;
import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CardCollectionService {

    //public List<CardCollectionModel> getCardsFromCollection(UserModel user);

    public CardsModel getCardFromCollection(long collectionDTO, long id);

    public String insertCardsToCollection(UserCollectionDTO collection);

    public CardsModel updateCardsFromCollection(long collecetionId, long cardId);

    public String deleteCardsFromCollection(UserCollectionDTO userCollectionDTO);

    public CardCollectionModel findCollection(long collection);
}
