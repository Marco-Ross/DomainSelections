package com.marco.factory.timings;

import com.marco.domain.timings.clientobject.NewSchedule;

public class NewScheduleFactory {
    public static NewSchedule buildNewSchedule(int trainNumber, int capacity, String departureDate, String departure, String arrival){
        return new NewSchedule.Builder()
                .trainNumber(trainNumber)
                .capacity(capacity)
                .departureDate(departureDate)
                .departure(departure)
                .arrival(arrival)
                .build();
    }
}
