package com.marco.service.actors.impl;

import com.marco.domain.actors.Customer;
import com.marco.repository.actors.actorrepo.CustomerRepository;
import com.marco.repository.actors.impl.CustomerRepositoryImpl;
import com.marco.service.actors.actorservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    @Qualifier("CustomerRepoImpl")
    private CustomerRepository repository;

    @Override
    public Set<Customer> getAllCustomers() {
        return this.repository.getAllCustomers();
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.update(customer);
    }

    @Override
    public void delete(String customer) {
        this.repository.delete(customer);
    }

    @Override
    public Customer read(String customer) {
        return this.repository.read(customer);
    }
}
