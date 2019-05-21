package com.marco.factory.actors;

import com.marco.domain.actors.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerFactoryTest {

    @Test
    public void getManager() {
        String name = "julies";
        String surname = "malema";
        int employeeNumber = 1234;
        Manager manager = ManagerFactory.buildManager(name, surname, employeeNumber);
        assertNotNull(manager.getName());
    }
}