package com.marco.factory.transit;

import com.marco.domain.transit.Station;
import org.junit.Test;

import static org.junit.Assert.*;

public class StationFactoryTest {

    @Test
    public void getStation() {
        String stationName = "myStation";
        int stationNumber = 5;
        Station station = StationFactory.getStation(stationName, stationNumber);
        assertNotNull(station.getStationName());
    }
}