package com.kodilla.customers.provider;

import com.kodilla.customers.connector.AccountDto;
import com.kodilla.customers.connector.AccountsConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    public List<AccountDto> getCustomerAccounts(long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                        account.getNrb(),
                        account.getCurrency(),
                        account.getAvailableFounds()))
                .collect(Collectors.toList());

    }
}