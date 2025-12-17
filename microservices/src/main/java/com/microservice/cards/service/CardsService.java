package com.microservice.cards.service;

import com.microservice.cards.dto.CardsDTO;

public interface CardsService {

    void createCard(String mobileNumber);

    CardsDTO fetchCard(String mobileNumber);

    boolean updateCard(CardsDTO CardsDTO);

    boolean deleteCard(String mobileNumber);
	
}
