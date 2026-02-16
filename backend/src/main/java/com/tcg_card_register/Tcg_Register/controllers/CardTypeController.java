package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.models.CardTypeModel;
import com.tcg_card_register.Tcg_Register.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cardtype/")
public class CardTypeController {
    @Autowired
    CardTypeService CTService;

    @GetMapping("/")
    public List<CardTypeModel> getAllCardTypes(){return CTService.getAllCardTypes();}

    @GetMapping("/{id}")
    public CardTypeModel findCardTypeById(@PathVariable Long id){return CTService.getCardTypeById(id);}

    @PostMapping("/create")
    public CardTypeModel createCardType(@RequestBody CardTypeModel cardtype) {return CTService.createCardType(cardtype);}

    @PutMapping("/update/{id}")
    public CardTypeModel updateCardType(@RequestBody CardTypeModel cardtype, @PathVariable Long id){return CTService.updateCardType(cardtype,id);}

    @DeleteMapping("/delete/{id}")
    public CardTypeModel deleteCardType(@PathVariable Long id){return CTService.deleteCardType(id);}

}
