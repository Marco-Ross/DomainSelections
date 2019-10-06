package com.marco.factory.actors;

import com.marco.domain.actors.TicketChecker;

public class TicketCheckerFactory {
    public static TicketChecker buildTicketChecker(int employeeNumber, String name, String surname){
        return new TicketChecker.Builder().name(name)
                .surname(surname)
                .employeeNumber(employeeNumber)
                .build();
    }
}
