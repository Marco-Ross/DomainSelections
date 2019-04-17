package com.marco.factory.timings;

import com.marco.domain.timings.Departure;

import java.util.Date;

public class DepartureFactory {
    public static Departure getDeparture(Date estimatedDepartureTime, String departureStation){
        return new Departure.Builder().estimatedDepartureTime(estimatedDepartureTime)
                .departureStation(departureStation)
                .build();
    }
}
