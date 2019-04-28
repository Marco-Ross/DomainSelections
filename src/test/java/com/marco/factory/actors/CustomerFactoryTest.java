package com.marco.factory.actors;

import com.marco.domain.actors.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFactoryTest {

    @Test
    public void getCustomer() {
        String name = "piet";
        String surname = "konnie";
        int age = 30;
        String idNumber = "1912185698256";

        Customer customer = CustomerFactory.getCustomer(name,surname,age,idNumber, 200);
        assertSame(customer.getIdNumber(), "1912185698256");
    }
}