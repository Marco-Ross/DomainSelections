package com.marco.factory.actors;

import com.marco.domain.actors.TicketClerk;

public class TicketClerkFactory {
    public static TicketClerk getTicketClerk(String name, String surname, int employeeNumber){
        return new TicketClerk.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
