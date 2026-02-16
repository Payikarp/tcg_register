package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.interfaces.CardCollectionRepository;
import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.service.CardCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addcards")
public class CardCollectionController {
    @Autowired
    private CardCollectionService cardCollectionService;
    @Autowired
    private CardCollectionRepository cardCollectionRepository;

    @GetMapping("/{id}")
    public List<CardCollectionModel> getAllCardsInCollection(@PathVariable UserCollectionModel collection){ return cardCollectionService.getCardsFromCollection(collection.getId());}

    @GetMapping("/{id}/{collectionId}/{cardId}")
    public CardsModel getCardInCollection(@PathVariable UserCollectionModel id, @PathVariable long collectionId, @PathVariable CardsModel cardId){return cardCollectionService.getCardFromCollection(id,collectionIdcardId);}

    @GetMapping("/findCollection/{id}")
    public CardCollectionModel findCardCollection (@PathVariable long id) {return cardCollectionService.findCollection(id);}

    @PostMapping(value = "/insert")
    public boolean insertCardsToCollection(@RequestBody UserCollectionDTO collection) {return cardCollectionService.insertCardsToCollection(collection);}

}
