package com.marco.factory;

import com.marco.domain.Train;
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