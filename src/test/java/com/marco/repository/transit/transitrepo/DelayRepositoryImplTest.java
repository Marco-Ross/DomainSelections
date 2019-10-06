//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Delay;
//import com.marco.domain.transit.Station;
//import com.marco.factory.transit.DelayFactory;
//import com.marco.factory.transit.StationFactory;
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
//public class DelayRepositoryImplTest {
//    @Autowired
//    private DelayRepository repository;
//    private Delay delay;
//
//    private Delay getRepo(){
//        for(Delay delayA : repository.findAll()){
//            if(delayA.getDelayId() == delay.getDelayId()){
//                return delayA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        delay = DelayFactory.buildDelay(10, "Man hit by train");
//    }
//
//    @Test
//    public void d_getAllStations() {
//        Set<Delay> arrayList = (Set<Delay>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Delay delayTest = this.repository.save(delay);
//
//        Assert.assertEquals(delay, delayTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String description = "Man stabbed";
//        Delay updated = new Delay.Builder().copy(getRepo()).description(description).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(description, updated.getDescription());
//        System.out.println("Delay updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(delay.getDelayId());
//        Set<Delay> stations = (Set<Delay>) repository.findAll();
//        Assert.assertEquals(0, stations.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Delay> delayRead = repository.findById(10);
//        Assert.assertTrue(delayRead.isPresent());
//        Assert.assertEquals(delay.getDelayId(), delayRead.get().getDelayId());
//    }
//}