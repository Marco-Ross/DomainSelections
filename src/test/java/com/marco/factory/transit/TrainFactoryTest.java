package com.marco.factory.transit;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainFactoryTest {

    @Test
    public void getTrain() {
        int capacity = 20;
        int trainNumber = 2545;

        Train train = TrainFactory.buildTrain(trainNumber, capacity);
        assertSame(40, train.getCapacity()); //using overbook util class

    }
}