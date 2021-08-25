package com.lemoncode21.springbootcassandracrud.repository;

import com.lemoncode21.springbootcassandracrud.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CustomerRepository extends CassandraRepository<Customer,Long> {
}
