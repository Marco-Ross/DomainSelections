package com.marco.factory.actors;

import com.marco.domain.actors.TicketClerk;

public class TicketClerkFactory {
    public static TicketClerk buildTicketClerk(int employeeNumber, String name, String surname){
        return new TicketClerk.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
