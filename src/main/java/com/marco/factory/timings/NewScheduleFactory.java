package com.marco.factory.timings;

import com.marco.domain.timings.NewSchedule;
import com.marco.util.RandomID;

import java.util.Date;

public class NewScheduleFactory {
    public static NewSchedule buildNewSchedule(String trainNumber, int capacity, String departure, String arrival){
        return new NewSchedule.Builder()
                .trainNumber(trainNumber)
                .capacity(capacity)
                .departure(departure)
                .arrival(arrival)
                .build();
    }
}
