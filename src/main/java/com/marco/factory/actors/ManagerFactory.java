package com.marco.factory.actors;

import com.marco.domain.actors.Manager;

public class ManagerFactory {
    public static Manager buildManager(String name, String surname, int employeeNumber){
        return new Manager.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
