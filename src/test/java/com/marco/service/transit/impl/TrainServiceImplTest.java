package com.marco.service.transit.impl;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import com.marco.service.transit.transitservice.TrainService;
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
public class TrainServiceImplTest {
    @Autowired
    @Qualifier("TrainServiceImpl")
    private TrainService service;
    private Train train;

    private Train getRepo(){
        for(Train trainA : service.getAllTrains()){
            if(trainA.getTrainNumber() == train.getTrainNumber()){
                return trainA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        if(service.getAllTrains().size() == 0){ train = TrainFactory.buildTrain( 2530, 200);}
        else{train = service.getAllTrains().iterator().next();}

    }

    @Test
    public void d_getAllTrains() {
        Set<Train> trainMap = service.getAllTrains();
        Assert.assertEquals(1, trainMap.size());
    }

    @Test
    public void a_create() {
        Train trainTest = this.service.create(train);

        Assert.assertEquals(train, trainTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        int capacity = 120;
        Train updated = new Train.Builder().copy(getRepo()).capacity(capacity).build();

        this.service.update(updated);

        Assert.assertEquals(capacity, updated.getCapacity());
        System.out.println("Train updated");
    }

    @Test
    public void e_delete() {
        service.delete(train.getTrainNumber());
        Set<Train> trainMap = service.getAllTrains();
        Assert.assertEquals(0, trainMap.size());
    }

    @Test
    public void b_read() {
        Optional<Train> trainRead = service.read(train.getTrainNumber());
        Assert.assertTrue(trainRead.isPresent());
        Assert.assertEquals(train.getTrainID(), trainRead.get().getTrainID());
    }
}