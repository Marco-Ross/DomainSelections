package com.marco.service.timings.timingservice;

import com.marco.domain.timings.NewSchedule;
import com.marco.domain.timings.TrainSchedule;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface TrainScheduleService extends ServiceGI<TrainSchedule, String> {
    Set<TrainSchedule> getAllTrainSchedules();
    NewSchedule readTime(String time);
    NewSchedule readTrain(String trainNumber);
}
