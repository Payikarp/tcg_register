package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
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
        return cardTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card type not found."));
    }

    @Override
    public CardTypeModel createCardType(CardTypeModel cardType)
    {
        try
        {
            return cardTypeRepo.save(cardType);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public CardTypeModel updateCardType(CardTypeModel cardType) {
        CardTypeModel prevCardType = cardTypeRepo.findById(cardType.getId()).orElseThrow(() -> new ResourceNotFoundException("Card type not found."));
        try
        {
            return cardTypeRepo.save(cardType);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public CardTypeModel deleteCardType(Long id) {
        CardTypeModel cardType = cardTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card type not found."));
        cardType.setStatus(2);
        try
        {
            return cardTypeRepo.save(cardType);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }
}
