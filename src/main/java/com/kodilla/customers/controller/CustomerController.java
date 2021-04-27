package com.kodilla.customers.controller;

import com.kodilla.customers.domain.CustomerDto;
import com.kodilla.customers.exception.CustomerNotFoundException;
import com.kodilla.customers.mapper.CustomerMapper;
import com.kodilla.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RefreshScope
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CustomerController {

    @Value("$(customers.allow-get-customers}")
    private boolean allowGetCustomers;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() { return customerMapper.mapToCustomerDtoList(customerService.getAllCustomers()); }

    @GetMapping("{customers/{customersId}")
    public CustomerDto getCustomer(@PathVariable long customerId) throws CustomerNotFoundException {
        return customerMapper.mapToCustomerDto(customerService.getCustomer(customerId).orElseThrow(CustomerNotFoundException::new));
    }

    @GetMapping
    public List<CustomerDto> getAccounts(@RequestParam("customerId") Long customerId) {
        if(!allowGetCustomers) {
            log.info("Getting accoutns is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }
        List<CustomerDto> customers = new ArrayList<>();
        return customers = customerMapper.mapToCustomerDtoList(customerService.getCustomersById(customerId));
    }
}
