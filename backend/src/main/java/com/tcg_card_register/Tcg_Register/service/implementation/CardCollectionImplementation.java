package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.dto.CardCollectionDTO;
import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.interfaces.CardCollectionRepository;
import com.tcg_card_register.Tcg_Register.interfaces.CardsRepository;
import com.tcg_card_register.Tcg_Register.interfaces.UserCollectionRepository;
import com.tcg_card_register.Tcg_Register.interfaces.UserRepository;
import com.tcg_card_register.Tcg_Register.models.CardCollectionModel;
import com.tcg_card_register.Tcg_Register.models.CardsModel;
import com.tcg_card_register.Tcg_Register.models.UserCollectionModel;
import com.tcg_card_register.Tcg_Register.models.UserModel;
import com.tcg_card_register.Tcg_Register.service.CardCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardCollectionImplementation implements CardCollectionService {
    @Autowired
    private CardCollectionRepository cardCollectionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCollectionRepository userCollectionRepository;
    @Autowired
    private CardsRepository cardsRepository;

    public List<CardCollectionModel> getCardsFromCollection(Long id) {
        return cardCollectionRepository.findAll();
    }

    /*public CardsModel getCardFromCollection(UserCollectionModel collectionId, CardsModel cardId) {
       return CCrepository.findByCollection_idAndCard_id(collectionId,cardId).orElse(null);
    }*/

    public boolean insertCardsToCollection(UserCollectionDTO collection) {
        List<CardCollectionDTO> cards = collection.getCards();
        UserModel user = userRepository.findById(collection.getUserId()).orElse(null);
        UserCollectionModel userCollection = userCollectionRepository.findById(collection.getCollectionId()).orElse(null);
        if(user == null || userCollection == null)
        {
            return false;
        }

        CardCollectionModel nCardCollection = new CardCollectionModel();
        nCardCollection.setCollectionId(userCollection);
        if(getIndividualCards(nCardCollection, cards))
        {
            return true;
        }
        return false;
    }

    public boolean updateCardsFromCollection(UserCollectionDTO collection) {
        List<CardCollectionDTO> cards = collection.getCards();
        UserModel user = userRepository.findById(collection.getUserId()).orElse(null);
        UserCollectionModel userCollection = userCollectionRepository.findById(collection.getCollectionId()).orElse(null);
        if(user == null || userCollection == null)
        {
            return false;
        }
        /*CardCollectionModel existingCardCollection = cardCollectionRepository.findById_CollectionId(collection.getCollectionId());
        if(getIndividualCards(existingCardCollection, cards))
        {
            return true;
        }*/

        return false;
    }

    public CardsModel deleteCardFromCollection(UUID id, Long card_id) {
        return null;
    }

    public boolean getIndividualCards(CardCollectionModel nCardCollection, List<CardCollectionDTO> cardList)
    {
        for(CardCollectionDTO card : cardList)
        {
            CardsModel infoCard = cardsRepository.findById(card.getCard()).orElse(null);
            cardCollectionRepository.save(new CardCollectionModel(nCardCollection.getCollectionId(),infoCard, card.getCardAmount()));
        }
        return true;
    }

    public CardCollectionModel findCollection(long collectionId)
    {
        UserCollectionModel userCollection = userCollectionRepository.findById(collectionId).orElse(null);
        if(userCollection == null)
        {
            return null;
        }
        return cardCollectionRepository.findByCollectionId(userCollection);
    }

}
