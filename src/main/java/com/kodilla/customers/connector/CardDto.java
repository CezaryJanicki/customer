package com.kodilla.customers.connector;

import lombok.Data;

@Data
public class CardDto {
    private Long id;
    private String type;
    private String nrb;

    public CardDto(String type, String nrb) {
        this.type = type;
        this.nrb = nrb;
    }
}
