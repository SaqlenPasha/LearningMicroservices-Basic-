package com.microservice.cards.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.microservice.cards.constants.CardsConstants;
import com.microservice.cards.dto.CardsDTO;
import com.microservice.cards.entity.Cards;
import com.microservice.cards.exception.CardAlreadyExistsException;
import com.microservice.cards.exception.ResourceNotFoundException;
import com.microservice.cards.mapper.CardsMapper;
import com.microservice.cards.repository.CardsRepository;
import com.microservice.cards.service.CardsService;

import lombok.AllArgsConstructor;

@Service
public class CardsServiceImpl implements CardsService {

    private CardsRepository cardsRepository;


    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards= cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }


    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }


    @Override
    public CardsDTO fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDTO());
    }


    @Override
    public boolean updateCard(CardsDTO CardsDTO) {
        Cards cards = cardsRepository.findByCardNumber(CardsDTO.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", CardsDTO.getCardNumber()));
        CardsMapper.mapToCards(CardsDTO, cards);
        cardsRepository.save(cards);
        return  true;
    }


    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }

}
