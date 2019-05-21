package com.marco.factory.actors;

import com.marco.domain.actors.TicketChecker;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketCheckerFactoryTest {

    @Test
    public void getTicketChecker() {
        String name = "lumba";
        String surname = "tiana";
        int employeeNumber = 3251;

        TicketChecker ticketChecker = TicketCheckerFactory.buildTicketChecker(name, surname, employeeNumber);
        assertNotNull(ticketChecker.getName());
    }
}