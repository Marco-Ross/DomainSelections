package com.marco.service.timings.timingservice;

import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.service.ServiceGI;

import java.util.Optional;
import java.util.Set;

public interface TrainScheduleService extends ServiceGI<TrainSchedule, Integer, Optional<TrainSchedule>> {
    Set<TrainSchedule> getAllTrainSchedules();
    NewSchedule readTime(String time);
    NewSchedule readTrain(int trainNumber);
}
