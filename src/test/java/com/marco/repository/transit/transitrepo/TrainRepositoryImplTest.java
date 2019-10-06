//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Train;
//import com.marco.factory.transit.TrainFactory;
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
//public class TrainRepositoryImplTest {
//    @Autowired
//    private TrainRepository repository;
//    private Train train;
//
//    private Train getRepo(){
//        for(Train trainA : repository.findAll()){
//            if(trainA.getTrainNumber() == train.getTrainNumber()){
//                return trainA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        Set<Train> trainFetch = (Set<Train>) repository.findAll();
//        if(trainFetch.size() == 0){ train = TrainFactory.buildTrain(3520, 200);}
//        else{train = trainFetch.iterator().next();}
//
//    }
//
//    @Test
//    public void d_getAllTrains() {
//        Set<Train> trainMap = (Set<Train>) repository.findAll();
//        Assert.assertEquals(1, trainMap.size());
//    }
//
//    @Test
//    public void a_create() {
//        Train trainTest = this.repository.save(train);
//
//        Assert.assertEquals(train, trainTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        int capacity = 120;
//        Train updated = new Train.Builder().copy(getRepo()).capacity(capacity).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(capacity, updated.getCapacity());
//        System.out.println("Train updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(train.getTrainNumber());
//        Set<Train> trainMap = (Set<Train>) repository.findAll();
//        Assert.assertEquals(0, trainMap.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Train> trainRead = repository.findById(train.getTrainID());
//        Assert.assertTrue(trainRead.isPresent());
//        Assert.assertEquals(train.getTrainID(), trainRead.get().getTrainID());
//    }
//}