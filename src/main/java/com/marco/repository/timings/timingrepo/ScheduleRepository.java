package com.marco.repository.timings.timingrepo;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface ScheduleRepository extends RepositoryGI<Schedule, String> {
    ArrayList<Schedule> getAllSchedules();
}
