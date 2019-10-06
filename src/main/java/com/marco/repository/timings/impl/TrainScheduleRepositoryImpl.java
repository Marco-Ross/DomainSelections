//package com.marco.repository.timings.impl;
//
//import com.marco.domain.timings.compositeclass.TrainSchedule;
//import com.marco.repository.timings.timingrepo.TrainScheduleRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository("TrainScheduleOne")
//public class TrainScheduleRepositoryImpl implements TrainScheduleRepository {
//    private Map<String, TrainSchedule> trainScheduleMap;
//
//    private TrainScheduleRepositoryImpl(){
//        trainScheduleMap = new HashMap<>();
//    }
//
//    @Override
//    public Set<TrainSchedule> getAllTrainSchedules() {
//        Collection<TrainSchedule> platforms = this.trainScheduleMap.values();
//        return new HashSet<>(platforms);
//    }
//
//    @Override
//    public TrainSchedule create(TrainSchedule trainSchedule) {
//        trainScheduleMap.put(trainSchedule.getScheduleID(), trainSchedule);
//        return trainScheduleMap.get(trainSchedule.getScheduleID());
//    }
//
//    @Override
//    public TrainSchedule update(TrainSchedule trainSchedule) {
//        this.trainScheduleMap.replace(trainSchedule.getScheduleID(), trainSchedule);
//        return this.trainScheduleMap.get(trainSchedule.getScheduleID());
//    }
//
//    @Override
//    public void delete(String trainScheduleID) {
//        this.trainScheduleMap.remove(trainScheduleID);
//    }
//
//    @Override
//    public TrainSchedule read(String trainScheduleID) {
//        return trainScheduleMap.get(trainScheduleID);
//    }
//}
