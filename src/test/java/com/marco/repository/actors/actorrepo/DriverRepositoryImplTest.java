//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.Driver;
//import com.marco.factory.actors.DriverFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class DriverRepositoryImplTest {
//    @Autowired
//    private DriverRepository repository;
//    private Driver driver;
//
//    private Driver getRepo(){
//        for(Driver driverA : repository.findAll()){
//            if(driverA.getEmployeeNumber() == driver.getEmployeeNumber()){
//                return driverA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        driver = DriverFactory.buildDriver(3654, "marco", "ross");
//
//    }
//
//    @Test
//    public void d_getAllDrivers() {
//        Set<Driver> driverSet = (Set<Driver>) repository.findAll();
//        Assert.assertEquals(1, driverSet.size());
//    }
//
//    @Test
//    public void a_create() {
//        Driver driverTest = this.repository.save(driver);
//        Assert.assertEquals(driver, driverTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "poopie";
//        Driver updated = new Driver.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("Driver updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(driver.getEmployeeNumber());
//        Set<Driver> driverSet = (Set<Driver>) repository.findAll();
//        Assert.assertEquals(0, driverSet.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Driver> driverRead = repository.findById(3654);
//        Assert.assertTrue(driverRead.isPresent());
//        Assert.assertEquals(driver.getEmployeeNumber(), driverRead.get().getEmployeeNumber());
//    }
//}