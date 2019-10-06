package com.marco.service.actors.impl;

import com.google.common.collect.Sets;
import com.marco.domain.actors.Customer;
import com.marco.repository.actors.actorrepo.CustomerRepository;
import com.marco.service.actors.actorservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Set<Customer> getAllCustomers() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public void delete(Integer customer) {
        this.repository.deleteById(customer);
    }

    @Override
    public Optional<Customer> read(Integer customer) {
        return this.repository.findById(customer);
    }
}
