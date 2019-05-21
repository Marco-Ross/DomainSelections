package com.marco.service.actors.impl;

import com.marco.domain.actors.Customer;
import com.marco.factory.actors.CustomerFactory;
import com.marco.service.actors.actorservice.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceImplTest {
    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService service;
    private Customer customer;

    private Customer getRepo(){
        for(Customer customerA : service.getAllCustomers()){
            if(customerA.getIdNumber().equals(customer.getIdNumber())){
                return customerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        customer = CustomerFactory.buildCustomer("marco", "ross", 23, "12345678910", 200);
    }

    @Test
    public void a_create() {
        Customer customerTest = this.service.create(customer);
        Assert.assertEquals(customer, customerTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        Customer updated = new Customer.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Customer updated");
    }

    @Test
    public void e_delete() {
        service.delete(customer.getIdNumber());
        Set<Customer> customerSet = service.getAllCustomers();
        Assert.assertEquals(0, customerSet.size());
    }

    @Test
    public void b_read() {
        Customer customerRead = service.read(customer.getIdNumber());
        Assert.assertSame(customer.getIdNumber(), customerRead.getIdNumber());
    }

    @Test
    public void d_getAllCustomers() {
        Set<Customer> customerSet = service.getAllCustomers();
        Assert.assertEquals(1, customerSet.size());
    }
}