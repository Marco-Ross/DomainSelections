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
        Train train = TrainFactory.getTrain(trainNumber, capacity);
        System.out.println(train.getCapacity());
        assertSame(train.getCapacity(), 40);

    }
}