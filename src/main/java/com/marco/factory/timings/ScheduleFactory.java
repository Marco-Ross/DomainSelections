package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;

import java.util.Date;

public class ScheduleFactory {
    public static Schedule getSchedule(String trainLocation, Date trainDelays){
        return new Schedule.Builder().trainLocation(trainLocation)
                .trainDelays(trainDelays)
                .build();
    }
}
