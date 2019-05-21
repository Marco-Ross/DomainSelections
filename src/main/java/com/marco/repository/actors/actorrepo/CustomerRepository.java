package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Customer;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface CustomerRepository extends RepositoryGI<Customer, String> {
    Set<Customer>getAllCustomers();
}
