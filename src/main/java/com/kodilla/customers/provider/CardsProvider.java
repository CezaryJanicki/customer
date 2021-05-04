package com.kodilla.customers.provider;

import com.kodilla.customers.connector.CardDto;
import com.kodilla.customers.connector.CardsConnector;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {

    private final CardsConnector cardsConnector;

    @HystrixCommand(fallbackMethod = "fallbackGetCards")
    public List<CardDto> getCustomerCards(long customerId) {
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(
                        card.getNrb(),
                        card.getType()))
                .collect(Collectors.toList());
    }

    private List<CardDto> fallbackGetCards(long customerId) { return Collections.emptyList(); }
}
