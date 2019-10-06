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
        int idNumber = 191218563;

        Customer customer = CustomerFactory.buildCustomer(idNumber, name, surname, age, 200);
        assertEquals(idNumber, customer.getIdNumber());
    }
}