package com.marco.service.timings.impl;

import com.marco.domain.timings.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.TrainSchedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
import com.marco.factory.timings.TrainScheduleFactory;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import com.marco.repository.timings.timingrepo.TrainScheduleRepository;
import com.marco.repository.transit.transitrepo.TrainRepository;
import com.marco.service.timings.timingservice.TrainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("TrainScheduleService")
public class TrainScheduleServiceImpl implements TrainScheduleService {

    @Autowired
    @Qualifier("TrainScheduleOne")
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    @Qualifier("ScheduleRepoImpl")
    private ScheduleRepository scheduleRepository;

    @Autowired
    @Qualifier("TrainRepoImpl")
    private TrainRepository trainRepository;

    @Override
    public Set<TrainSchedule> getAllTrainSchedules() {
        return trainScheduleRepository.getAllTrainSchedules();
    }

    @Override
    public TrainSchedule create(TrainSchedule trainSchedule) {
        return trainScheduleRepository.create(trainSchedule);
    }

    @Override
    public TrainSchedule update(TrainSchedule trainSchedule) {
        return trainScheduleRepository.update(trainSchedule);
    }

    @Override
    public void delete(String trainScheduleID) {
        trainScheduleRepository.delete(trainScheduleID);
    }

    @Override
    public TrainSchedule read(String trainScheduleID) {
        return trainScheduleRepository.read(trainScheduleID);
    }

    @Override
    public NewSchedule readTime(String time) {
        for (Schedule schedule : scheduleRepository.getAllSchedules()) {
            if (schedule.getDeparture().equals(time)) {
                for (TrainSchedule trainSchedule : trainScheduleRepository.getAllTrainSchedules()) {
                    if (schedule.getScheduleID().equals(trainSchedule.getScheduleID())) {
                        for(Train train : trainRepository.getAllTrains()){
                            if(train.getTrainNumber().equals(trainSchedule.getTrainNumber())){
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
    public NewSchedule readTrain(String trainNumber) {
        for(Train train : trainRepository.getAllTrains()){
            if(train.getTrainNumber().equals(trainNumber)){
                for (TrainSchedule trainSchedule : trainScheduleRepository.getAllTrainSchedules()) {
                    if (trainNumber.equals(trainSchedule.getTrainNumber())) {
                        for (Schedule schedule : scheduleRepository.getAllSchedules()) {
                            if (schedule.getScheduleID().equals(trainSchedule.getScheduleID())) {
                                return NewScheduleFactory.buildNewSchedule(train.getTrainNumber(), train.getCapacity(), schedule.getDeparture(), schedule.getArrival());
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
