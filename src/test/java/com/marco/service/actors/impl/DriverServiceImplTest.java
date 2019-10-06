package com.marco.service.actors.impl;

import com.marco.domain.actors.Driver;
import com.marco.factory.actors.DriverFactory;
import com.marco.service.actors.actorservice.DriverService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverServiceImplTest {
    @Autowired
    @Qualifier("DriverServiceImpl")
    private DriverService service;
    private Driver driver;

    private Driver getRepo(){
        for(Driver driverA : service.getAllDrivers()){
            if(driverA.getEmployeeNumber() == driver.getEmployeeNumber()){
                return driverA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.buildDriver(3654,"marco", "ross");

    }

    @Test
    public void d_getAllDrivers() {
        Set<Driver> driverSet = service.getAllDrivers();
        Assert.assertEquals(1, driverSet.size());
    }

    @Test
    public void a_create() {
        Driver driverTest = this.service.create(driver);
        Assert.assertEquals(driver.getEmployeeNumber(), driverTest.getEmployeeNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "poopie";
        Driver updated = new Driver.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Driver updated");
    }

    @Test
    public void e_delete() {
        service.delete(driver.getEmployeeNumber());
        Set<Driver> driverSet = service.getAllDrivers();
        Assert.assertEquals(0, driverSet.size());
    }

    @Test
    public void b_read() {
        Optional<Driver> driverRead = service.read(3654);
        Assert.assertTrue(driverRead.isPresent());
        Assert.assertEquals(driver.getEmployeeNumber(), driverRead.get().getEmployeeNumber());
    }
}