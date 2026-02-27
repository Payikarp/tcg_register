package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.service.CardsService;
import com.tcg_card_register.Tcg_Register.service.UserService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {
    @Autowired
    private CardsService cardService;

    @GetMapping("/")
    private List<CardsModel> getAllCards() {return cardService.getAllCards();};

    @PutMapping(value = "/update", consumes = "application/json")
    private CardsModel updateCard(@RequestBody  CardsModel card) {return cardService.updateCard(card);};

    @DeleteMapping("/delete/{id}")
    private CardsModel deleteCard(@PathVariable  Long id) {return cardService.deleteCard(id);};

    @GetMapping("/{id}")
    private CardsModel findCardById(@PathVariable  Long id) {return cardService.findCardById(id);};

    @PostMapping("/create")
    private CardsModel createCard(@RequestBody  CardsModel card) {return cardService.createCard(card);};

}
