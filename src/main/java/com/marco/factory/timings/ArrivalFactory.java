package com.marco.factory.timings;

import com.marco.domain.timings.Arrival;

import java.util.Date;

public class ArrivalFactory {
    public static Arrival getArrival(Date estimatedArrivalTime, String arrivalStation){
        return new Arrival.Builder().estimatedArrivalTime(estimatedArrivalTime)
                .arrivalStation(arrivalStation)
                .build();
    }
}
