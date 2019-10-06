//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.DoorMan;
//import com.marco.factory.actors.DoorManFactory;
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
//public class DoorManRepositoryImplTest {
//    @Autowired
//    private DoorManRepository repository;
//    private DoorMan doorMan;
//
//    private DoorMan getRepo(){
//        for(DoorMan doorManA : repository.findAll()){
//            if(doorManA.getEmployeeNumber() == doorMan.getEmployeeNumber()){
//                return doorManA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        doorMan = DoorManFactory.buildDoorMan(3654, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllDrivers() {
//        Set<DoorMan> doorMenSet = (Set<DoorMan>) repository.findAll();
//        Assert.assertEquals(1, doorMenSet.size());
//    }
//
//    @Test
//    public void a_create() {
//        DoorMan doorManTest = this.repository.save(doorMan);
//        Assert.assertEquals(doorMan, doorManTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "doopies";
//        DoorMan updated = new DoorMan.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("DoorMan updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(doorMan.getEmployeeNumber());
//        Set<DoorMan> driverSet = (Set<DoorMan>) repository.findAll();
//        Assert.assertEquals(0, driverSet.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<DoorMan> doorManRead = repository.findById(3654);
//        Assert.assertTrue(doorManRead.isPresent());
//        Assert.assertEquals(doorMan.getEmployeeNumber(), doorManRead.get().getEmployeeNumber());
//    }
//}