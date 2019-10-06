package com.marco.factory.actors;

import com.marco.domain.actors.Announcer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnnouncerFactoryTest {

    @Test
    public void buildAnnouncer() {
        String name = "marco";
        String surname = "rossy";
        int employeeNumber = 125;

        Announcer announcer = AnnouncerFactory.buildAnnouncer(employeeNumber, name, surname);

        assertSame(employeeNumber, announcer.getEmployeeNumber());
    }
}