package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Driver;
import com.marco.factory.actors.DriverFactory;
import com.marco.repository.repositoryinterfaces.actorrepo.DriverRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class DriverRepositoryImplTest {
    private DriverRepository repository;
    private Driver driver;

    @Before
    public void setUp() throws Exception {
        this.repository = DriverRepositoryImpl.getRepository();
        driver = DriverFactory.getDriver("marco", "ross", 3654);
        this.repository.create(driver);
    }

    @After
    public void tearDown() throws Exception {
        Set<Driver> driverSet = repository.getAllDrivers();
        driverSet.clear();
    }

    @Test
    public void getAllDrivers() {
        Set<Driver> driverSet = repository.getAllDrivers();
        Assert.assertEquals(1, driverSet.size());
    }

    @Test
    public void create() {
        Driver driverCreate = DriverFactory.getDriver("peter", "guy", 3069);
        Driver driverTestCreate = this.repository.create(driverCreate);

        Assert.assertEquals(driverCreate, driverTestCreate);
    }

    @Test
    public void update() {
        Driver driverTest = DriverFactory.getDriver("marco", "hardy", 3654);
        this.repository.update(driverTest);

        Set<Driver> driverSet = repository.getAllDrivers();
        Assert.assertTrue(driverSet.contains(driverTest));
        System.out.println("Driver updated");
    }

    @Test
    public void delete() {
        repository.delete(driver);
        Set<Driver> driverSet = repository.getAllDrivers();
        Assert.assertEquals(0, driverSet.size());
    }

    @Test
    public void read() {
        Driver driverRead = repository.read(3654);
        Assert.assertEquals(driver, driverRead);
    }
}