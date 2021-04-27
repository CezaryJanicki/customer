package com.kodilla.customers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private long id;
    private String firstname;
    private String lastname;
}
