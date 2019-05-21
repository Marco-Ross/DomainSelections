package com.marco.service.timings.timingservice;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface ScheduleService extends ServiceGI<Schedule, Integer> {
    ArrayList<Schedule> getAllSchedules();
}
