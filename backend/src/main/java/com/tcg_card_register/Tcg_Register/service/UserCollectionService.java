package com.tcg_card_register.Tcg_Register.service;

import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCollectionService {

    public List<UserCollectionModel> getAllUserCollections(long userId);

    public UserCollectionModel getUserCollectionsById(long user_id, long collectionId);

    public UserCollectionModel createUserCollection(UserCollectionDTO userDTO);

    public UserCollectionModel updateUserCollection(UserCollectionDTO userCollectionDTO);

    public UserCollectionModel deleteUserCollection(Long collectionId);

}
