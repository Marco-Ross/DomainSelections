package com.marco.factory.actors;

import com.marco.domain.actors.Driver;

public class DriverFactory {
    public static Driver buildDriver(int employeeNumber, String name, String surname){
        return new Driver.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
