package com.marco.factory.timings;

import com.marco.domain.timings.Departure;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DepartureFactoryTest {

    @Test
    public void getDeparture() {
        Date estimatedDepartureTime = new Date();
        String departureStation = "Cape Town";
        Departure departure = DepartureFactory.getDeparture(estimatedDepartureTime, departureStation);
        assertNotNull(departure.getDepartureStation());
    }
}