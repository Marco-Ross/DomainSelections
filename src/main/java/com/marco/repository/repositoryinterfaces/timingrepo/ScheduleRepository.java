package com.marco.repository.repositoryinterfaces.timingrepo;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface ScheduleRepository extends RepositoryGI<Schedule, Train> {
    ArrayList<Schedule> getAllSchedules();
}
