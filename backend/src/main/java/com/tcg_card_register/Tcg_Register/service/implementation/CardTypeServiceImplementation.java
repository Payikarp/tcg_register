package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.interfaces.CardTypeRepository;
import com.tcg_card_register.Tcg_Register.models.CardTypeModel;
import com.tcg_card_register.Tcg_Register.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardTypeServiceImplementation implements CardTypeService {
    @Autowired
    private CardTypeRepository cardTypeRepo;

    @Override
    public List<CardTypeModel> getAllCardTypes() {
        return cardTypeRepo.findAll();
    }

    @Override
    public CardTypeModel getCardTypeById(Long id) {
        return cardTypeRepo.findById(id).orElse(null);
    }

    @Override
    public CardTypeModel createCardType(CardTypeModel cardType) {
        return cardTypeRepo.save(cardType);
    }

    @Override
    public CardTypeModel updateCardType(CardTypeModel cardType, Long id) {
        CardTypeModel prevCardType = cardTypeRepo.findById(id).orElse(null);
        if(prevCardType == null)
        {
            return null;
        }
        prevCardType.setType(cardType.getType());
        return cardTypeRepo.save(prevCardType);
    }

    @Override
    public CardTypeModel deleteCardType(Long id) {
        CardTypeModel cardType = cardTypeRepo.findById(id).orElse(null);
        if(cardType == null)
        {
            return null;
        }
        cardType.setStatus(2);
        return cardTypeRepo.save(cardType);
    }
}
