package com.marco.factory.actors;

import com.marco.domain.actors.Driver;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverFactoryTest {

    @Test
    public void getDriver() {
        String name = "kyle";
        String surname = "julies";
        int employeeNumber = 3365;
        Driver driver = DriverFactory.getDriver(name, surname, employeeNumber);
        assertNotNull(driver.getName());
    }
}