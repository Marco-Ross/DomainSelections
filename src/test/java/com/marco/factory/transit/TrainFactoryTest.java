package com.marco.factory.transit;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainFactoryTest {

    @Test
    public void getTrain() {
        int trainNumber = 2539;
        int capacity = 20;
        String trainName = "Johnny";

        Train train = TrainFactory.buildTrain(trainNumber, capacity, trainName);
        assertSame(40, train.getCapacity()); //using overbook util class

    }
}