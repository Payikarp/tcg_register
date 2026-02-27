package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ItemAlreadyInDatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
import com.tcg_card_register.Tcg_Register.interfaces.CardsRepository;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import com.tcg_card_register.Tcg_Register.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImplementation implements CardsService {
    @Autowired
    CardsRepository cardRepository;

    public CardsModel updateCard(CardsModel card)
    {
        try
        {
            return cardRepository.save(card);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

    @Override
    public CardsModel deleteCard(Long id) {
        CardsModel card = cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card not found."));
        card.setStatus(2);
        try
        {
            return cardRepository.save(card);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }

    }

    @Override
    public List<CardsModel> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public CardsModel findCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card not found."));
    }

    @Override
    public CardsModel createCard(CardsModel card) {
        CardsModel searchCard = cardRepository.findByNameAndSetExpansionAndSetNumber(card.getName(),card.getSetExpansion(),card.getSetNumber());
        if(searchCard == null) { throw new ItemAlreadyInDatabaseException("The card already exists.");}
        try
        {
            return cardRepository.save(card);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }

}
