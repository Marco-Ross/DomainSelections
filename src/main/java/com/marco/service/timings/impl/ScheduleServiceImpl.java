package com.marco.service.timings.impl;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.timings.impl.ScheduleRepositoryImpl;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import com.marco.service.timings.timingservice.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ScheduleServiceImpl")
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    @Qualifier("ScheduleRepoImpl")
    private ScheduleRepository repository;

    @Override
    public ArrayList<Schedule> getAllSchedules() {
        return this.repository.getAllSchedules();
    }

    @Override
    public Schedule create(Schedule schedule) {
        return this.repository.create(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return this.repository.update(schedule);
    }

    @Override
    public void delete(String scheduleID) {
        this.repository.delete(scheduleID);
    }

    @Override
    public Schedule read(String scheduleID) {
        return this.repository.read(scheduleID);
    }
}
