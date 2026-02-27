package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.dto.CardCollectionDTO;
import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.interfaces.CardCollectionRepository;
import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
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

    /*@GetMapping("/{id}")
    public List<CardCollectionModel> getAllCardsInCollection(@PathVariable UserModel collection){ return cardCollectionService.getCardsFromCollection(collection);}*/

    @GetMapping("/{collectionId}/{cardId}")
    public CardsModel getCardInCollection(@PathVariable long collectionId, @PathVariable long cardId){return cardCollectionService.getCardFromCollection(collectionId,cardId);}

    @GetMapping("/findCollection/{id}")
    public CardCollectionModel findCardCollection (@PathVariable long id) {return cardCollectionService.findCollection(id);}

    @PostMapping(value = "/insert")
    public String insertCardsToCollection(@RequestBody UserCollectionDTO collection) {return cardCollectionService.insertCardsToCollection(collection);}

    @PutMapping("/update/{collectionId}/{cardId}")
    public CardsModel updateCardFromCollection(@PathVariable long collectionId, @PathVariable long cardId) {return cardCollectionService.updateCardsFromCollection(collectionId, cardId);}

    @DeleteMapping("/delete")
    public String deleteCardsFromCollection(@RequestBody UserCollectionDTO userCollectionDTO) {return  cardCollectionService.deleteCardsFromCollection(userCollectionDTO);}
}
