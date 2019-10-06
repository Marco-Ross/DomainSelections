package com.marco.factory.timings;

import com.marco.domain.timings.clientobject.NewSchedule;

public class NewScheduleFactory {
    public static NewSchedule buildNewSchedule(int trainNumber, int capacity, String departure, String arrival){
        return new NewSchedule.Builder()
                .trainNumber(trainNumber)
                .capacity(capacity)
                .departure(departure)
                .arrival(arrival)
                .build();
    }
}
