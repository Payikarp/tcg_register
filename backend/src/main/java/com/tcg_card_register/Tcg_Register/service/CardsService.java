package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardsService {
    public CardsModel updateCard(CardsModel user);

    public CardsModel deleteCard(Long id);

    public List<CardsModel> getAllCards();

    public CardsModel findCardById(Long id);

    public CardsModel createCard(CardsModel card);
}
