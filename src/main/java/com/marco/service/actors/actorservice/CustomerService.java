package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Customer;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface CustomerService extends ServiceGI<Customer, String> {
    Set<Customer> getAllCustomers();
}
