package com.kodilla.customers.connector.response;

import com.kodilla.customers.connector.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCardsResponse {
    private List<CardDto> cards;
}
