package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.transit.transitrepo.TrainRepository;
import com.marco.repository.transit.impl.TrainRepositoryImpl;
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
public class TrainRepositoryImplTest {
    @Autowired
    @Qualifier("TrainRepoImpl")
    private TrainRepository repository;
    private Train train;

    private Train getRepo(){
        for(Train trainA : repository.getAllTrains()){
            if(trainA.getTrainNumber() == train.getTrainNumber()){
                return trainA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        train = TrainFactory.buildTrain(2553, 200, "SpeedyTrain");
    }

    @Test
    public void d_getAllTrains() {
        Set<Train> arrayList = repository.getAllTrains();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Train trainTest = this.repository.create(train);

        Assert.assertEquals(train, trainTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        int capacity = 120;
        Train updated = new Train.Builder().copy(getRepo()).capacity(capacity).build();

        this.repository.update(updated);

        Assert.assertEquals(capacity, updated.getCapacity());
        System.out.println("Train updated");
    }

    @Test
    public void e_delete() {
        repository.delete(train.getTrainNumber());
        Set<Train> trains = repository.getAllTrains();
        Assert.assertEquals(0, trains.size());
    }

    @Test
    public void b_read() {
        Train trainRead = repository.read(2553);
        Assert.assertEquals(train.getTrainNumber(), trainRead.getTrainNumber());
    }
}