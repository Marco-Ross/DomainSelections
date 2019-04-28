package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Customer;
import com.marco.repository.repositoryinterfaces.actorrepo.CustomerRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl repository = null;
    private Set<Customer> customers;

    private CustomerRepositoryImpl(){
        this.customers = new HashSet<>();
    }

    public static CustomerRepositoryImpl getRepository(){
        if(repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        this.customers.add(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        for(Customer customerC : customers){
           if(customer.getIdNumber().equals(customerC.getIdNumber())){
               this.customers.remove(customerC);
               this.customers.add(customer);
           }
        }
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        this.customers.remove(customer);
    }

    @Override
    public Customer read(String customerId) {
        Customer customer = null;
        for(Customer customerC : customers){
            if(customerId.equals(customerC.getIdNumber())){
                customer = customerC;
            }
        }
        return customer;
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return this.customers;
    }
}
