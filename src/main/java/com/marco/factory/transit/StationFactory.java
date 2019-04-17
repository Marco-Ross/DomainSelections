package com.marco.factory.transit;

import com.marco.domain.transit.Station;

public class StationFactory {
    public static Station getStation(String stationName, int stationNumber){
        return new Station.Builder().stationName(stationName)
                .stationNumber(stationNumber)
                .build();
    }
}
