package com.kodilla.customers.service;

import com.kodilla.customers.domain.Customer;
import com.kodilla.customers.domain.CustomerDto;
import com.kodilla.customers.mapper.CustomerMapper;
import com.kodilla.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public Optional<Customer> getCustomer(final Long id) { return customerRepository.findById(id); }

    public Optional<CustomerDto> findCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::mapToCustomerDto);
    }

    public Customer getCustomerById(final Long id) { return customerRepository.getCustomerById(id); }

    public List<Customer> getAllCustomers() { return customerRepository.findAll(); }

    public Customer saveCustomer(final Customer customer) {return customerRepository.save(customer); }

    public void deleteCustomer(long customerId) { customerRepository.deleteById(customerId); }

    public List<Customer> getCustomersById(Long customerId) {
        return new ArrayList<>();
    }
}
