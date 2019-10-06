package com.marco.service.timings.timingservice;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface ScheduleService extends ServiceGI<Schedule, Integer, Optional<Schedule>> {
    ArrayList<Schedule> getAllSchedules();
}
