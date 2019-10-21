package com.marco.service.timings.impl;

import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import com.marco.service.timings.timingservice.ScheduleService;
import com.marco.service.timings.timingservice.TrainScheduleService;
import com.marco.service.transit.impl.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("ScheduleServiceImpl")
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Autowired
    private TrainServiceImpl trainService;

    @Autowired
    private TrainScheduleService trainScheduleService;

    @Override
    public ArrayList<Schedule> getAllSchedules() {
        return (ArrayList<Schedule>) this.repository.findAll();
    }

    @Override
    public Schedule create(Schedule schedule) {
        return this.repository.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return this.repository.save(schedule);
    }

    @Override
    public void delete(Integer scheduleID) {
        this.repository.deleteById(scheduleID);
    }

    @Override
    public Optional<Schedule> read(Integer scheduleID) {
        return this.repository.findById(scheduleID);
    }

    public Schedule getScheduleWithTrainNumber(int trainNumber){
        Train trainReceived = trainService.getTrainWithTrainNumber(trainNumber); //Read train to get ID

        for(TrainSchedule trainSchedule : trainScheduleService.getAllTrainSchedules()){
            if(trainSchedule.getTrainID()== trainReceived.getTrainID()){
                for(Schedule schedule : repository.findAll()){
                    if(schedule.getScheduleID() == trainSchedule.getScheduleID()){
                        return schedule;
                    }
                }
            }
        }return null;
    }

    public ArrayList<NewSchedule> getAllTrainSchedules(){
        ArrayList<NewSchedule> newSchedules = new ArrayList<>();
        for (TrainSchedule trainSchedule : trainScheduleService.getAllTrainSchedules()) {
            for(Train train : trainService.getAllTrains()){
                if (trainSchedule.getTrainID() == train.getTrainID()) {
                    for (Schedule schedule : repository.findAll()) {
                        if (schedule.getScheduleID() == trainSchedule.getScheduleID()) {
                            newSchedules.add(NewScheduleFactory.buildNewSchedule(train.getTrainNumber(), train.getCapacity(),schedule.getDepartureDate(), schedule.getDeparture(), schedule.getArrival()));
                        }
                    }
                }
            }
        }
        return newSchedules;
    }
}
