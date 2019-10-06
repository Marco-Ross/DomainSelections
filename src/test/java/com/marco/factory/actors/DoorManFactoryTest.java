package com.marco.factory.actors;

import com.marco.domain.actors.DoorMan;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorManFactoryTest {
    @Test
    public void getDoorMan() {
        String name = "julies";
        String surname = "mimi";
        int employeeNumber = 666;
        DoorMan doorMan = DoorManFactory.buildDoorMan(employeeNumber, name, surname);
        assertNotNull(doorMan.getName());
    }
}