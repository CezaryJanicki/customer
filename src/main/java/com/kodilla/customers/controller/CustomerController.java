package com.kodilla.customers.controller;

import com.kodilla.customers.connector.AccountDto;
import com.kodilla.customers.connector.CardDto;
import com.kodilla.customers.connector.response.GetCustomerProductsResponse;
import com.kodilla.customers.connector.response.GetCustomerResponse;
import com.kodilla.customers.domain.CustomerDto;
import com.kodilla.customers.exception.CustomerNotFoundException;
import com.kodilla.customers.mapper.CustomerMapper;
import com.kodilla.customers.service.CustomerService;
import com.kodilla.customers.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RefreshScope
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CustomerController {

    //@Value("$(application.allow-get-customers}")
    //private boolean allowGetCustomers;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ProductService productService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() { return customerMapper.mapToCustomerDtoList(customerService.getAllCustomers()); }

    //@GetMapping("/{customerId}")
    //public CustomerDto getCustomer(@PathVariable long customerId) throws CustomerNotFoundException {
    //    return customerMapper.mapToCustomerDto(customerService.getCustomer(customerId).orElseThrow(CustomerNotFoundException::new));
    //}

    @GetMapping("/accounts/{customerId}")
    public List<CustomerDto> getAccounts(@RequestParam("customerId") Long customerId) {
        if(!true) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }
        List<CustomerDto> customers = new ArrayList<>();
        return customers = customerMapper.mapToCustomerDtoList(customerService.getCustomersById(customerId));
    }

    @GetMapping("/{customerId}")
    public GetCustomerResponse getCustomer(@PathVariable Long customerId) {
        return customerService.findCustomer(customerId)
                .map(GetCustomerResponse:: new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{customerId}/products")
    public GetCustomerProductsResponse getCustomerProduct(@PathVariable Long customerId) {
        CustomerDto customerDto = customerService.findCustomer(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);
        List<CardDto> customerCards = productService.findCustomerCards(customerId);
        return GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstname() + " " + customerDto.getLastname())
                .accounts(customerAccounts)
                .cards(customerCards)
                .build();
    }
}
