package com.kodilla.customers.repository;

import com.kodilla.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(long id);
    Customer getCustomerById(Long customer);

    @Override
    List<Customer> findAll();

    @Override
    Customer save(Customer customer);

    void deleteById(long id);
}
