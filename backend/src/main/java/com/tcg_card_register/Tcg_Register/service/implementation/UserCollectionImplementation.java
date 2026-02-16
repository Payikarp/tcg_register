package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
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
        return userCollectionRepository.findByUserIdAndId(user_id,collectionId);
    }


    public UserCollectionModel createUserCollection(UserCollectionDTO userDTO) {
        UserModel user = UserRepository.findById(userDTO.getUserId()).orElse(null);
        if(user == null)
        {
            return null;
        }
        UserCollectionModel nCollection = new UserCollectionModel();
        nCollection.setUserId(userDTO.getUserId());
        nCollection.setCollection_name(userDTO.getCollectionName());
        nCollection.setTotalCards(0);
        nCollection.setStatus(1);
        return userCollectionRepository.save(nCollection);
    }


    public UserCollectionModel updateUserCollection(Long collection_id, String name, Long total) {
        UserCollectionModel collection = userCollectionRepository.findById(collection_id).orElse(null);
        if(collection==null)
        {
            return null;
        }
        collection.setCollection_name(name);
        collection.setTotalCards(total);
        return userCollectionRepository.save(collection);
    }


    public UserCollectionModel deleteUserCollection(Long collection_id) {
        UserCollectionModel collection = userCollectionRepository.findById(collection_id).orElse(null);
        if(collection==null)
        {
            return null;
        }
        collection.setStatus(2);
        return userCollectionRepository.save(collection);
    }
}
