package com.kodilla.customers.service;

import com.kodilla.customers.domain.Customer;
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

    public Optional<Customer> getCustomer(final Long id) { return customerRepository.findById(id); }

    public Customer getCustomerById(final Long id) { return customerRepository.getCustomerById(id); }

    public List<Customer> getAllCustomers() { return customerRepository.findAll(); }

    public Customer saveCustomer(final Customer customer) {return customerRepository.save(customer); }

    public void deleteCustomer(long customerId) { customerRepository.deleteById(customerId); }

    public List<Customer> getCustomersById(Long customerId) {
        return new ArrayList<>();
    }
}
