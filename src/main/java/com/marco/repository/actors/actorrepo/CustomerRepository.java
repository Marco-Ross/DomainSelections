package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Customer;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
