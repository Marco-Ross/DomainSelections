package com.marco.factory.timings;

import com.marco.domain.timings.Arrival;
import com.marco.domain.timings.Departure;

import java.util.Date;

public class ArrivalFactory {
    public static Arrival getArrival(int arrivalId, String arrivalStation){
        return new Arrival.Builder().arrivalId(arrivalId)
                .arrivalStation(arrivalStation)
                .build();
    }
}
