package com.kodilla.customers.mapper;

import com.kodilla.customers.domain.Customer;
import com.kodilla.customers.domain.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer mapToCustomer(final CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getFirstname(), customerDto.getLastname());
    }

    public CustomerDto mapToCustomerDto(final Customer customer) {
        return new CustomerDto(customer.getId(), customer.getFirstname(), customer.getLastname());
    }

    public List<CustomerDto> mapToCustomerDtoList(final List<Customer> customerList) {
        return customerList.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public List<Customer> mapToCustomerList(final List<CustomerDto> customerDtoList) {
        return customerDtoList.stream()
                .map(this::mapToCustomer)
                .collect(Collectors.toList());
    }

}
