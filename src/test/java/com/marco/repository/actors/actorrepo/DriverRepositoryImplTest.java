package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Driver;
import com.marco.factory.actors.DriverFactory;
import com.marco.repository.actors.impl.DriverRepositoryImpl;
import com.marco.repository.actors.actorrepo.DriverRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverRepositoryImplTest {
    @Autowired
    @Qualifier("DriverRepoImpl")
    private DriverRepository repository;
    private Driver driver;

    private Driver getRepo(){
        for(Driver driverA : repository.getAllDrivers()){
            if(driverA.getEmployeeNumber() == driver.getEmployeeNumber()){
                return driverA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.buildDriver("marco", "ross", 3654);

    }

    @Test
    public void d_getAllDrivers() {
        Set<Driver> driverSet = repository.getAllDrivers();
        Assert.assertEquals(1, driverSet.size());
    }

    @Test
    public void a_create() {
        Driver driverTest = this.repository.create(driver);
        Assert.assertEquals(driver, driverTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "poopie";
        Driver updated = new Driver.Builder().copy(getRepo()).surname(surname).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Driver updated");
    }

    @Test
    public void e_delete() {
        repository.delete(driver.getEmployeeNumber());
        Set<Driver> driverSet = repository.getAllDrivers();
        Assert.assertEquals(0, driverSet.size());
    }

    @Test
    public void b_read() {
        Driver driverRead = repository.read(3654);
        Assert.assertEquals(driver.getEmployeeNumber(), driverRead.getEmployeeNumber());
    }
}