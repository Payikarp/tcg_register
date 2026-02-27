package com.tcg_card_register.Tcg_Register.interfaces;

import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardCollectionRepository extends JpaRepository<CardCollectionModel, UUID> {

   //Optional<CardsModel> findByCollection_idAndCard_id(UserCollectionModel collection_id, CardsModel card_id);
    CardCollectionModel findByCollectionId(UserCollectionModel collectionId);
    CardCollectionModel findByCollectionIdAndCardId(UserCollectionModel collectionId, CardsModel cardId);
}
