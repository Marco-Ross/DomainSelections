package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import com.marco.util.RandomID;

import java.util.Date;

public class ScheduleFactory {
    public static Schedule buildSchedule(String departure, String arrival){
        return new Schedule.Builder().scheduleID(RandomID.generateRandomID())
                .departure(departure)
                .arrival(arrival)
                .build();
    }
}
