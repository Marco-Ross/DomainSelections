package com.marco.controller.timings;

import com.marco.domain.credentials.Profile;
import com.marco.domain.timings.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.TrainSchedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.timings.TrainScheduleFactory;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import com.marco.repository.timings.timingrepo.TrainScheduleRepository;
import com.marco.repository.transit.impl.TrainRepositoryImpl;
import com.marco.repository.transit.transitrepo.TrainRepository;
import com.marco.service.credentials.credentialservice.ProfileService;
import com.marco.service.timings.impl.ScheduleServiceImpl;
import com.marco.service.timings.impl.TrainScheduleServiceImpl;
import com.marco.service.timings.timingservice.ScheduleService;
import com.marco.service.timings.timingservice.TrainScheduleService;
import com.marco.service.transit.impl.TrainServiceImpl;
import com.marco.service.transit.transitservice.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/railway/schedule")
public class ScheduleController {
    @Autowired
    @Qualifier("ScheduleServiceImpl")
    private ScheduleService scheduleService;

    @Autowired
    @Qualifier("TrainScheduleService")
    private TrainScheduleService trainScheduleService;

    @Autowired
    @Qualifier("TrainServiceImpl")
    private TrainService trainService;

    @Autowired
    @Qualifier("ScheduleRepoImpl")
    private ScheduleRepository scheduleRepository;

    @Autowired
    @Qualifier("TrainRepoImpl")
    private TrainRepository trainRepository;

    private Schedule saveSchedule;
    private Train saveTrain;

    @PostMapping("/create")
    @ResponseBody
    public Schedule create(@RequestBody NewSchedule newSchedule){
        Schedule schedule = ScheduleFactory.buildSchedule(newSchedule.getDeparture(), newSchedule.getArrival());
        Schedule savedSchedule = scheduleService.create(schedule);

        TrainSchedule trainSchedule = TrainScheduleFactory.buildTrainSchedule(schedule.getScheduleID(), newSchedule.getTrainNumber());

        trainScheduleService.create(trainSchedule);
        return savedSchedule;
    }

    @PostMapping("/old")
    @ResponseBody
    private void getInfoForUpdate(@RequestBody NewSchedule newSchedule){
        for (TrainSchedule trainSchedule : trainScheduleService.getAllTrainSchedules()) {
            if (newSchedule.getTrainNumber().equals(trainSchedule.getTrainNumber())) {
                for (Schedule schedule : scheduleRepository.getAllSchedules()) {
                    if (schedule.getScheduleID().equals(trainSchedule.getScheduleID())) {
                        for(Train train : trainRepository.getAllTrains()){
                            if(train.getTrainNumber().equals(newSchedule.getTrainNumber())){
                                saveSchedule = schedule;
                                saveTrain = train;
                            }
                        }
                    }
                }
            }
        }
    }

    @PutMapping("/update")
    @ResponseBody //Use Json mapper to add both old and new objects to body instead of having above method and sending info to separate calls.
    public Train update(@RequestBody NewSchedule newSchedule){
        Schedule schedule = new Schedule.Builder().copy(saveSchedule).departure(newSchedule.getDeparture()).arrival(newSchedule.getArrival()).build();
        Train train = new Train.Builder().copy(saveTrain).trainNumber(newSchedule.getTrainNumber()).capacity(newSchedule.getCapacity()).build();
        TrainSchedule trainSchedule = TrainScheduleFactory.buildTrainSchedule(schedule.getScheduleID(), train.getTrainNumber());

        Train t= trainService.update(train);
        scheduleService.update(schedule);
        trainScheduleService.update(trainSchedule);

        return t;
    }

    @DeleteMapping("/delete/{trainNumber}")
    @ResponseBody
    public void delete(@PathVariable String trainNumber){
        scheduleService.delete(saveSchedule.getScheduleID());
        trainService.delete(trainNumber);
        trainScheduleService.delete(saveSchedule.getScheduleID());
    }

    @GetMapping("/read/{time}")
    @ResponseBody
    public NewSchedule read(@PathVariable String time){
        return trainScheduleService.readTime(time);
    }

    @GetMapping("/readTrain/{trainNumber}")
    @ResponseBody
    public NewSchedule readTrain(@PathVariable String trainNumber){
        return trainScheduleService.readTrain(trainNumber);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Schedule> getAllSchedules(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ScheduleHeader"));
        return scheduleService.getAllSchedules();
    }
}
