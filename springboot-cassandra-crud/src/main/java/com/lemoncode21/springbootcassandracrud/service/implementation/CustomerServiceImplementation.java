package com.lemoncode21.springbootcassandracrud.service.implementation;

import com.lemoncode21.springbootcassandracrud.model.Customer;
import com.lemoncode21.springbootcassandracrud.repository.CustomerRepository;
import com.lemoncode21.springbootcassandracrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerList = this.customerRepository.findById(id);
        if(customerList.isEmpty()){
            System.out.print("Customer id not found");
        }
        customerList.get().setName(customer.getName());
        customerList.get().setAge(customer.getAge());
        customerList.get().setCustomerActive(customer.getCustomerActive());
    }
}
