package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Customer;
import com.marco.factory.actors.CustomerFactory;
import com.marco.repository.impl.actorimpl.CustomerRepositoryImpl;
import com.marco.repository.repositoryinterfaces.actorrepo.CustomerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class CustomerRepositoryImplTest {
    private CustomerRepository repository;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        this.repository = CustomerRepositoryImpl.getRepository();
        customer = CustomerFactory.getCustomer("marco", "ross", 23, "12345678910", 200);
        this.repository.create(customer); //create and add customer to data structure
    }

    @After
    public void tearDown() throws Exception {
        Set<Customer> customerSet = repository.getAllCustomers();
        customerSet.clear();
    }

    @Test
    public void create() {
        Customer customerCreate = CustomerFactory.getCustomer("peter", "guy", 30, "45878968958", 250);
        Customer customerTestCreate = this.repository.create(customerCreate); //create and add customer to data structure

        Assert.assertEquals(customerCreate, customerTestCreate);
    }

    @Test
    public void update() {
        Customer customerTest = CustomerFactory.getCustomer("marco", "hardy", 24, "12345678910", 200);
        this.repository.update(customerTest); //update customer details

        Set<Customer> customerSet = repository.getAllCustomers(); //get all customers
        Assert.assertTrue(customerSet.contains(customerTest));
        System.out.println("Customer updated");
    }

    @Test
    public void delete() {
        repository.delete(customer);
        Set<Customer> customerSet = repository.getAllCustomers();
        Assert.assertEquals(0, customerSet.size());
    }

    @Test
    public void read() {
        Customer customerRead = repository.read("12345678910");
        Assert.assertEquals(customer, customerRead);
    }

    @Test
    public void getAllCustomers() {
        Set<Customer> customerSet = repository.getAllCustomers();
        Assert.assertEquals(1, customerSet.size());
    }
}