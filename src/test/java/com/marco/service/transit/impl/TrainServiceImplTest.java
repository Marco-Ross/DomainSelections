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

import java.util.Set;

import static org.junit.Assert.*;

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
        train = TrainFactory.buildTrain(2553, 200, "Tony");
    }

    @Test
    public void d_getAllTrains() {
        Set<Train> arrayList = service.getAllTrains();
        Assert.assertEquals(1, arrayList.size());
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
        Set<Train> trains = service.getAllTrains();
        Assert.assertEquals(0, trains.size());
    }

    @Test
    public void b_read() {
        Train trainRead = service.read(2553);
        Assert.assertEquals(train.getTrainNumber(), trainRead.getTrainNumber());
    }
}