package com.marco.repository.repositoryinterfaces.actorrepo;

import com.marco.domain.actors.Customer;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface CustomerRepository extends RepositoryGI<Customer, String> {
    Set<Customer>getAllCustomers();
}
