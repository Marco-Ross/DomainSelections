//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Carriage;
//import com.marco.factory.transit.CarriageFactory;
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
//public class CarriageRepositoryImplTest {
//    @Autowired
//    private CarriageRepository repository;
//    private Carriage carriage;
//
//    private Carriage getRepo(){
//        for(Carriage carriageA : repository.findAll()){
//            if(carriageA.getCarriageNumber() == carriage.getCarriageNumber()){
//                return carriageA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        carriage = CarriageFactory.buildCarriage(12, 50);
//    }
//
//    @Test
//    public void d_getAllCarriages() {
//        Set<Carriage> set = (Set<Carriage>) repository.findAll();
//        Assert.assertEquals(1, set.size());
//    }
//
//    @Test
//    public void a_create() {
//        Carriage carriageTest = this.repository.save(carriage);
//
//        Assert.assertEquals(carriage, carriageTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        int capacity = 32;
//        Carriage updated = new Carriage.Builder().copy(getRepo()).capacity(capacity).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(capacity, updated.getCapacity());
//        System.out.println("Carriages updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(carriage.getCarriageNumber());
//        Set<Carriage> carriages = (Set<Carriage>) repository.findAll();
//        Assert.assertEquals(0, carriages.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Carriage> carriageRead = repository.findById(12);
//        Assert.assertTrue(carriageRead.isPresent());
//        Assert.assertEquals(carriage.getCarriageNumber(), carriageRead.get().getCarriageNumber());
//    }
//}