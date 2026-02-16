package com.tcg_card_register.Tcg_Register.controllers;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/collection")
public class UserCollectionController {
    @Autowired
    private UserCollectionService UCS;

    @GetMapping("/{id}")
    public List<UserCollectionModel> getUserCollections(@PathVariable Long id) { return UCS.getAllUserCollections(id);}

    @GetMapping("/{userId}/{collectionId}")
    public UserCollectionModel getUserCollectionById(@PathVariable  long userId, @PathVariable long collectionId) {return UCS.getUserCollectionsById(userId, collectionId);}

    @PostMapping("/create")
    public UserCollectionModel createUserCollection(@RequestBody UserCollectionDTO userDTO) {return UCS.createUserCollection(userDTO);}

    @PutMapping(value = "/update", consumes = "application/json")
    public UserCollectionModel updateUserCollection(@RequestBody UserCollectionModel collection) {return UCS.updateUserCollection(collection.getId(), collection.getCollection_name(), collection.getTotalCards());}

    @DeleteMapping("/delete")
    public UserCollectionModel deleteUserCollection(@RequestBody UserCollectionModel collection) {return UCS.deleteUserCollection(collection.getId());}
}
