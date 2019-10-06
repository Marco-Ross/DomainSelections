package com.marco.factory.actors;

import com.marco.domain.actors.Manager;

public class ManagerFactory {
    public static Manager buildManager(int employeeNumber, String name, String surname){
        return new Manager.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
