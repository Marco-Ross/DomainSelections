package com.marco.factory.actors;

import com.marco.domain.actors.Security;

public class SecurityFactory {
    public static Security buildSecurity(String name, String surname, int employeeNumber){
        return new Security.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
