package com.marco.factory.actors;

import com.marco.domain.actors.Driver;

public class DriverFactory {
    public static Driver buildDriver(String name, String surname, int employeeNumber){
        return new Driver.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
