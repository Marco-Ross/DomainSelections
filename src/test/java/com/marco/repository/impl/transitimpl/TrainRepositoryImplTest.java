package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.repositoryinterfaces.transitrepo.TrainRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainRepositoryImplTest {
    private TrainRepository repository;
    private Train train;

    @Before
    public void setUp() throws Exception {
        this.repository = TrainRepositoryImpl.getRepository();
        train = TrainFactory.getTrain(2553, 200);
        this.repository.create(train);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Train> arrayList = repository.getAllTrains();
        arrayList.clear();
    }

    @Test
    public void getAllTrains() {
        ArrayList<Train> arrayList = repository.getAllTrains();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Train train = TrainFactory.getTrain(9154, 150);
        Train trainTest = this.repository.create(train);

        Assert.assertEquals(train, trainTest);
    }

    @Test
    public void update() {
        Train train = TrainFactory.getTrain(2553, 135);
        this.repository.update(train);

        ArrayList<Train> trains = repository.getAllTrains();
        Assert.assertTrue(trains.contains(train));
        System.out.println("Train updated");
    }

    @Test
    public void delete() {
        repository.delete(train);
        ArrayList<Train> trains = repository.getAllTrains();
        Assert.assertEquals(0, trains.size());
    }

    @Test
    public void read() {
        Train trainList = repository.read(2553);
        Assert.assertEquals(trainList, train);
    }
}