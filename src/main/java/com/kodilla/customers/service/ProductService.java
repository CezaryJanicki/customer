package com.kodilla.customers.service;

import com.kodilla.customers.connector.AccountDto;
import com.kodilla.customers.connector.CardDto;
import com.kodilla.customers.provider.AccountsProvider;
import com.kodilla.customers.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountsProvider;

    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountsProvider.getCustomerAccounts(customerId);
    }

    public List<CardDto> findCustomerCards(Long customerId) {
        return cardsProvider.getCustomerCards(customerId);
    }
}
