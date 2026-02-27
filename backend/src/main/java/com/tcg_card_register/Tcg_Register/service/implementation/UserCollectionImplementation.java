package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
import com.tcg_card_register.Tcg_Register.interfaces.UserCollectionRepository;
import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import com.tcg_card_register.Tcg_Register.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectionImplementation implements UserCollectionService {
    @Autowired
    private UserCollectionRepository userCollectionRepository;
    @Autowired
    private UserRepository UserRepository;


    public List<UserCollectionModel> getAllUserCollections(long userId) {
        return userCollectionRepository.findAllByUserId(userId);
    }

    public UserCollectionModel getUserCollectionsById(long user_id, long collectionId) {
        UserCollectionModel userCollection = userCollectionRepository.findByUserIdAndId(user_id,collectionId);
        if(userCollection == null){ throw new ResourceNotFoundException("User collection not found.");}
        return userCollection;

    }


    public UserCollectionModel createUserCollection(UserCollectionDTO userDTO) {
        UserModel user = UserRepository.findById(userDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        //Create collection
        UserCollectionModel nCollection = new UserCollectionModel();
        nCollection.setUserId(userDTO.getUserId());
        nCollection.setCollectionName(userDTO.getCollectionName());
        nCollection.setTotalCards(0);
        nCollection.setStatus(1);

        try
        {
            return userCollectionRepository.save(nCollection);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }


    public UserCollectionModel updateUserCollection(UserCollectionDTO userCollectionDTO) {
        UserCollectionModel collection = userCollectionRepository.findById(userCollectionDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        //Update collection
        collection.setCollectionName(userCollectionDTO.getCollectionName());
        collection.setTotalCards(userCollectionDTO.getCardTotal());
        collection.setStatus(userCollectionDTO.getStatus());
        try
        {
            return userCollectionRepository.save(collection);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }


    public UserCollectionModel deleteUserCollection(Long collectionId) {
        UserCollectionModel collection = userCollectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        collection.setStatus(2);
        try
        {
            return userCollectionRepository.save(collection);
        }catch (Exception exception)
        {
            throw new DatabaseException("Error saving to the database: "+ exception.getMessage());
        }
    }
}
