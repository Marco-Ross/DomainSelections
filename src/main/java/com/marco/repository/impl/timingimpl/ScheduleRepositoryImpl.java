package com.marco.repository.impl.timingimpl;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.repositoryinterfaces.timingrepo.ScheduleRepository;

import java.util.ArrayList;

public class ScheduleRepositoryImpl implements ScheduleRepository {
    private static ScheduleRepositoryImpl repository = null;
    private ArrayList<Schedule> schedules;

    private ScheduleRepositoryImpl(){
        this.schedules = new ArrayList<>();
    }

    public static ScheduleRepositoryImpl getRepository(){
        if(repository == null) repository = new ScheduleRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Schedule> getAllSchedules() {
        return this.schedules;
    }

    @Override
    public Schedule create(Schedule schedule) {
        this.schedules.add(schedule);
        return schedule;
    }

    @Override
    public Schedule update(Schedule schedule) {
        for(int i = 0; i<schedules.size();i++){
            if(schedule.getTrainNumber() == schedules.get(i).getTrainNumber()){
                this.schedules.set(i, schedule);
            }
        }
        return schedule;
    }

    @Override
    public void delete(Schedule schedule) {
        this.schedules.remove(schedule);
    }

    @Override
    public Schedule read(Train train) {
        Schedule schedule = null;
        for(Schedule scheduleA : schedules){
            if(train.getTrainNumber() == scheduleA.getTrainNumber()){
                schedule = scheduleA;
            }
        }
        return schedule;
    }
}
