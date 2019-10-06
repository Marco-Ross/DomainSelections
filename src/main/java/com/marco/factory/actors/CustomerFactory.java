package com.marco.factory.actors;

import com.marco.domain.actors.Customer;

public class CustomerFactory {
    public static Customer buildCustomer(int idNumber, String name, String surname, int age, double balance){
        return new Customer.Builder().name(name)
                .surname(surname)
                .age(age)
                .idNumber(idNumber)
                .balance(balance)
                .build();
    }
}
