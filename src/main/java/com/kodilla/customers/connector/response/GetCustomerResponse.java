package com.kodilla.customers.connector.response;

import com.kodilla.customers.domain.CustomerDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetCustomerResponse extends CustomerDto {

    public GetCustomerResponse(CustomerDto customerDto) {
        super(customerDto.getId(), customerDto.getFirstname(), customerDto.getLastname());
    }
}
