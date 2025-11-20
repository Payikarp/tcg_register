package com.tcg_card_register.Tcg_Register.service.implementation;

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
        return cardRepository.save(card);
    }

    @Override
    public CardsModel deleteCard(Long id) {
        CardsModel card = cardRepository.findById(id).orElse(null);
        if(card==null)
        {
            return null;
        }else
        {
            card.setStatus(2);
            return cardRepository.save(card);
        }
    }

    @Override
    public List<CardsModel> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public CardsModel findCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public CardsModel createCard(CardsModel card) {
        return cardRepository.save(card);
    }

}
