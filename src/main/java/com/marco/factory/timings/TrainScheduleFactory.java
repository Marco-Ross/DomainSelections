package com.marco.factory.timings;

import com.marco.domain.timings.compositeclass.TrainSchedule;

public class TrainScheduleFactory {
    public static TrainSchedule buildTrainSchedule(int scheduleID,int trainID){
        return new TrainSchedule.Builder().scheduleID(scheduleID)
                .trainID(trainID)
                .build();
    }
}
