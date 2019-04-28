package com.marco.factory.actors;

import com.marco.domain.actors.Customer;

public class CustomerFactory {
    public static Customer getCustomer(String name, String surname, int age, String idNumber, double balance){
        return new Customer.Builder().name(name)
                .surname(surname)
                .age(age)
                .idNumber(idNumber)
                .balance(balance)
                .build();
    }
}
