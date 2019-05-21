package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;

import java.util.Date;

public class ScheduleFactory {
    public static Schedule buildSchedule(Date departure, Date arrival, Train train){
        return new Schedule.Builder().departure(departure)
                .arrival(arrival)
                .train(train)
                .build();
    }
}
