package com.kodilla.customers.connector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFounds;

    public AccountDto(String nrb, String currency, BigDecimal availableFounds) {
        this.nrb = nrb;
        this.currency = currency;
        this.availableFounds = availableFounds;
    }
}
