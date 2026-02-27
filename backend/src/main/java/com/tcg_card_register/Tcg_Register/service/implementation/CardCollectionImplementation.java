package com.tcg_card_register.Tcg_Register.service.implementation;

import com.tcg_card_register.Tcg_Register.dto.CardCollectionDTO;
import com.tcg_card_register.Tcg_Register.dto.UserCollectionDTO;
import com.tcg_card_register.Tcg_Register.exceptions.DatabaseException;
import com.tcg_card_register.Tcg_Register.exceptions.ResourceNotFoundException;
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
import java.util.Optional;

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

    public CardsModel getCardFromCollection(long collectionId, long cardId) {
        //UserModel user = userRepository.findById(collectionDTO.getUserId()).orElse(null);
        UserCollectionModel userCollection = userCollectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));;
        CardsModel searchCard = cardsRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException("Card not found."));
        CardCollectionModel cardCollectionModel = cardCollectionRepository.findByCollectionIdAndCardId(userCollection,searchCard);
        if(cardCollectionModel == null)
        {
            throw new ResourceNotFoundException("Card not found in collection.");
        }
        return cardsRepository.findById(cardCollectionModel.getCardId().getId()).orElseThrow(() -> new ResourceNotFoundException("Card not found in collection."));
    }

    public String insertCardsToCollection(UserCollectionDTO collection) {
        List<CardCollectionDTO> cards = collection.getCards();
        UserModel user = userRepository.findById(collection.getUserId()).orElseThrow(() -> new ResourceNotFoundException(("Couldn't find the card trying to be inserted in the collection.")));
        UserCollectionModel userCollection = userCollectionRepository.findById(collection.getCollectionId()).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        //Insert card into the collection
        CardCollectionModel nCardCollection = new CardCollectionModel();
        nCardCollection.setCollectionId(userCollection);
        if(getIndividualCards(nCardCollection, cards))
        {
            return "Cards added correctly.";
        }
        throw new DatabaseException("Couldn't add the cards.");
    }

    public CardsModel updateCardsFromCollection(long collectionId, long cardId) {
        UserCollectionModel userCollection = userCollectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        CardsModel searchCard = cardsRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException("Card not found."));
        CardCollectionModel cardCollectionModel = cardCollectionRepository.findByCollectionIdAndCardId(userCollection,searchCard);
        if(cardCollectionModel == null)
        {
            throw new ResourceNotFoundException("Card not found in collection.");
        }
        CardsModel card = cardsRepository.findById(cardCollectionModel.getCardId().getId()).orElseThrow(() -> new ResourceNotFoundException("Card not found in collection."));
        return cardsRepository.save(card);
    }

    public String deleteCardsFromCollection(UserCollectionDTO userCollectionDTO) {
        List<CardCollectionDTO> cardList = userCollectionDTO.getCards();
        UserCollectionModel userCollection = userCollectionRepository.findById(userCollectionDTO.getCollectionId()).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        if(deleteCards(userCollection, cardList))
        {
            return "Cards deleted correctly.";
        }
        throw new DatabaseException("Couldn't add the cards.");
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

    public boolean deleteCards(UserCollectionModel userCollection, List<CardCollectionDTO> cardList)
    {

        for(CardCollectionDTO card : cardList)
        {
            CardsModel infoCard = cardsRepository.findById(card.getCard()).orElse(null);
            CardCollectionModel cardEntry = cardCollectionRepository.findByCollectionIdAndCardId(userCollection, infoCard);
            cardCollectionRepository.delete(cardEntry);
        }
        return true;
    }

    public CardCollectionModel findCollection(long collectionId)
    {
        UserCollectionModel userCollection = userCollectionRepository.findById(collectionId).orElseThrow(() -> new ResourceNotFoundException("User's collection not found."));
        if(userCollection == null)
        {
            return null;
        }
        return cardCollectionRepository.findByCollectionId(userCollection);
    }

}
