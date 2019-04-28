package com.marco.factory.timings;

import com.marco.domain.timings.Arrival;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ArrivalFactoryTest {

    @Test
    public void getArrival() {
        String arrivalStation = "Thornton";
        Arrival arrival = ArrivalFactory.getArrival(2, arrivalStation);
        assertNotNull(arrival.getArrivalStation());
    }
}