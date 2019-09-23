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
            if(schedule.getScheduleID().equals(schedules.get(i).getScheduleID())){
                this.schedules.set(i, schedule);
                return schedule;
            }
        }
        return null;
    }

    @Override
    public void delete(String scheduleID) {
        for(Schedule scheduleA : schedules){
            if(scheduleID.equals(scheduleA.getScheduleID())){
                this.schedules.remove(scheduleA);
                break;
            }
        }
    }

    @Override
    public Schedule read(String scheduleID) {
        for(Schedule scheduleA : schedules){
            if(scheduleID.equals(scheduleA.getScheduleID())){
                return scheduleA;
            }
        }
        return null;
    }
}
