package com.kodilla.customers.connector.response;

import com.kodilla.customers.connector.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class GetCustomerProductsResponse {
        private Long customerId;
        private String fullName;
        private List<AccountDto> accounts;
    }

