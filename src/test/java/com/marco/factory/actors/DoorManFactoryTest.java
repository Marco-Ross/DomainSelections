package com.marco.factory.actors;

import com.marco.domain.actors.Customer;
import com.marco.domain.actors.DoorMan;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;
import com.marco.factory.actors.DoorManFactory;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.factory.credentials.ProfileFactory;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DoorManFactoryTest {
    @Test
    public void getDoorMan() {
        String name = "julies";
        String surname = "mimi";
        int employeeNumber = 666;
        DoorMan doorMan = DoorManFactory.buildDoorMan(name, surname, employeeNumber);
        assertNotNull(doorMan.getName());
    }
}