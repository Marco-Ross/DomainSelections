package com.marco.repository.timings.timingrepo;

import com.marco.domain.timings.TrainSchedule;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface TrainScheduleRepository extends RepositoryGI<TrainSchedule, String> {
    Set<TrainSchedule> getAllTrainSchedules();
}
