package com.marco.service.timings.timingservice;

import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.domain.timings.compositeclass.TrainScheduleId;
import com.marco.service.ServiceGI;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TrainScheduleService extends ServiceGI<TrainSchedule, TrainScheduleId, Optional<TrainSchedule>> {
    Set<TrainSchedule> getAllTrainSchedules();
    List<NewSchedule> readTime(String date, String time);
    NewSchedule readTrain(int trainNumber);
}
