package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.models.CardTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardTypeService {
    public List<CardTypeModel> getAllCardTypes();

    public CardTypeModel getCardTypeById(Long id);

    public CardTypeModel createCardType(CardTypeModel cardType);

    public CardTypeModel updateCardType(CardTypeModel cardType, Long id);

    public CardTypeModel deleteCardType(Long id);
}
