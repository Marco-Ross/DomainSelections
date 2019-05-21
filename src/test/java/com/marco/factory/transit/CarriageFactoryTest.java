package com.marco.factory.transit;

import com.marco.domain.transit.Carriage;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarriageFactoryTest {

    @Test
    public void getCarriage() {
        int carriageNumber = 2;
        int capacity = 50;
        Carriage carriage = CarriageFactory.buildCarriage(carriageNumber, capacity);
        assertSame(capacity, carriage.getCapacity());
    }
}