package com.marco.factory.actors;

import com.marco.domain.actors.Security;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityFactoryTest {

    @Test
    public void getSecurity() {
        String name = "owen";
        String surname = "dawson";
        int employeeNumber = 8756;
        Security security = SecurityFactory.buildSecurity(employeeNumber, name, surname);
        assertNotNull(security.getName(), security.getSurname());
    }
}