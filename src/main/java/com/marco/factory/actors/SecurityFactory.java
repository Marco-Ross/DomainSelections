package com.marco.factory.actors;

import com.marco.domain.actors.Security;

public class SecurityFactory {
    public static Security buildSecurity(int employeeNumber, String name, String surname){
        return new Security.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
