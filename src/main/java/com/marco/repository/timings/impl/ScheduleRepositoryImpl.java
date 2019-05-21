package com.marco.repository.timings.impl;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("ScheduleRepoImpl")
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private ArrayList<Schedule> schedules;

    private ScheduleRepositoryImpl(){
        this.schedules = new ArrayList<>();
    }

    @Override
    public ArrayList<Schedule> getAllSchedules() {
        return this.schedules;
    }

    @Override
    public Schedule create(Schedule schedule) {
        this.schedules.add(schedule);
        for(Schedule scheduleA : schedules){
            if(schedule == scheduleA){
                return scheduleA;
            }
        }
        return null;
    }

    @Override
    public Schedule update(Schedule schedule) {
        for(int i = 0; i<schedules.size();i++){
            if(schedule.getTrain().getTrainNumber() == schedules.get(i).getTrain().getTrainNumber()){
                this.schedules.set(i, schedule);
                return schedule;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer trainNumber) {
        for(Schedule scheduleA : schedules){
            if(trainNumber == scheduleA.getTrain().getTrainNumber()){
                this.schedules.remove(scheduleA);
                break;
            }
        }
    }

    @Override
    public Schedule read(Integer trainNumber) {
        for(Schedule scheduleA : schedules){
            if(trainNumber == scheduleA.getTrain().getTrainNumber()){
                return scheduleA;
            }
        }
        return null;
    }
}
