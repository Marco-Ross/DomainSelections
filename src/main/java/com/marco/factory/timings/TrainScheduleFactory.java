package com.marco.factory.timings;

import com.marco.domain.timings.TrainSchedule;

public class TrainScheduleFactory {
    public static TrainSchedule buildTrainSchedule(String scheduleID,String trainID){
        return new TrainSchedule.Builder().scheduleID(scheduleID)
                .trainNumber(trainID)
                .build();
    }
}
