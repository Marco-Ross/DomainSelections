package com.marco.service.timings.impl;

import com.google.common.collect.Sets;
import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
import com.marco.repository.timings.timingrepo.TrainScheduleRepository;
import com.marco.service.timings.timingservice.ScheduleService;
import com.marco.service.timings.timingservice.TrainScheduleService;
import com.marco.service.transit.transitservice.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("TrainScheduleService")
public class TrainScheduleServiceImpl implements TrainScheduleService {

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainService trainService;

    @Override
    public Set<TrainSchedule> getAllTrainSchedules() {
        return Sets.newHashSet(trainScheduleRepository.findAll());
    }

    @Override
    public TrainSchedule create(TrainSchedule trainSchedule) {
        return trainScheduleRepository.save(trainSchedule);
    }

    @Override
    public TrainSchedule update(TrainSchedule trainSchedule) {
        return trainScheduleRepository.save(trainSchedule);
    }

    @Override
    public void delete(Integer trainScheduleID) {
        trainScheduleRepository.deleteById(trainScheduleID);
    }

    @Override
    public Optional<TrainSchedule> read(Integer trainScheduleID) {
        return trainScheduleRepository.findById(trainScheduleID);
    }

    @Override
    public NewSchedule readTime(String time) {
        for (Schedule schedule : scheduleService.getAllSchedules()) {
            if (schedule.getDeparture().equals(time)) {
                for (TrainSchedule trainSchedule : trainScheduleRepository.findAll()) {
                    if (schedule.getScheduleID() == trainSchedule.getScheduleID()) {
                        for(Train train : trainService.getAllTrains()){
                            if(train.getTrainID() == trainSchedule.getTrainID()){
                                return NewScheduleFactory.buildNewSchedule(train.getTrainNumber(), train.getCapacity(), schedule.getDeparture(), schedule.getArrival());
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public NewSchedule readTrain(int trainNumber) {
        if(trainService.getTrainWithTrainNumber(trainNumber) == null){
            return null;
        }

        Train trainReceived = trainService.getTrainWithTrainNumber(trainNumber); //Read train to get ID
        for (TrainSchedule trainSchedule : trainScheduleRepository.findAll()) {
            if (trainReceived.getTrainID() == trainSchedule.getTrainID()) {
                for (Schedule schedule : scheduleService.getAllSchedules()) {
                    if (schedule.getScheduleID() == trainSchedule.getScheduleID()) {
                        return NewScheduleFactory.buildNewSchedule(trainReceived.getTrainNumber(), trainReceived.getCapacity(), schedule.getDeparture(), schedule.getArrival());
                    }
                }
            }
        }
        return null;
    }
}
