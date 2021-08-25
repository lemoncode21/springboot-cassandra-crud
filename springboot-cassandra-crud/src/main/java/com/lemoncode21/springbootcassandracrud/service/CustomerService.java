package com.lemoncode21.springbootcassandracrud.service;

import com.lemoncode21.springbootcassandracrud.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> getById(Long id);

    List<Customer> getAll();

    void save(Customer customer);

    void delete(Long id);

    void update(Long id,Customer customer);

}
