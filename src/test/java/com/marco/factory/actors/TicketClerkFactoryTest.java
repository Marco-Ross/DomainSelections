package com.marco.factory.actors;

import com.marco.domain.actors.TicketClerk;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketClerkFactoryTest {

    @Test
    public void getTicketClerk() {
        String name = "owen";
        String surname = "dawson";
        int employeeNumber = 8756;
        TicketClerk ticketClerk = TicketClerkFactory.getTicketClerk(name, surname, employeeNumber);
        assertNotNull(ticketClerk.getName(), ticketClerk.getSurname());
    }
}