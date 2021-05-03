package com.kodilla.customers.service;

import com.kodilla.customers.connector.AccountDto;
import com.kodilla.customers.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountsProvider.getCustomerAccounts(customerId);
    }
}
