package com.marco.controller.timings;

import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.timings.TrainScheduleFactory;
import com.marco.service.timings.impl.ScheduleServiceImpl;
import com.marco.service.timings.timingservice.TrainScheduleService;
import com.marco.service.transit.impl.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/railway/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Autowired
    @Qualifier("TrainScheduleService")
    private TrainScheduleService trainScheduleService;

    @Autowired
    private TrainServiceImpl trainService;

    @PostMapping("/create")
    @ResponseBody
    public Schedule create(@RequestBody NewSchedule newSchedule){
        Schedule schedule = ScheduleFactory.buildSchedule(newSchedule.getDeparture(), newSchedule.getArrival());
        Schedule savedSchedule = scheduleService.create(schedule);

        Train train = trainService.getTrainWithTrainNumber(newSchedule.getTrainNumber());

        TrainSchedule trainSchedule = TrainScheduleFactory.buildTrainSchedule(schedule.getScheduleID(), train.getTrainID());
        trainScheduleService.create(trainSchedule);

        return savedSchedule;
    }

    @PutMapping("/update")
    @ResponseBody
    public Train update(@RequestBody NewSchedule newSchedule){
        Schedule scheduleRequested = scheduleService.getScheduleWithTrainNumber(newSchedule.getTrainNumber());
        Train trainRequested = trainService.getTrainWithTrainNumber(newSchedule.getTrainNumber());

        Schedule schedule = new Schedule.Builder().copy(scheduleRequested).departure(newSchedule.getDeparture()).arrival(newSchedule.getArrival()).build();
        Train train = new Train.Builder().copy(trainRequested).capacity(newSchedule.getCapacity()).build();

        Train t= trainService.update(train);
        scheduleService.update(schedule);

        return t;
    }

    @DeleteMapping("/delete/{trainNumber}")
    @ResponseBody
    public void delete(@PathVariable Integer trainNumber){
        Schedule schedule = scheduleService.getScheduleWithTrainNumber(trainNumber);
        scheduleService.delete(schedule.getScheduleID());
        trainService.delete(trainNumber);
        trainScheduleService.delete(schedule.getScheduleID());
    }

    @GetMapping("/readTime/{time}")
    @ResponseBody
    public NewSchedule readTime(@PathVariable String time){
        return trainScheduleService.readTime(time);
    }

    @GetMapping("/readTrain/{trainNumber}")
    @ResponseBody
    public NewSchedule readTrain(@PathVariable int trainNumber){
        return trainScheduleService.readTrain(trainNumber);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Schedule> getAllSchedules(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ScheduleHeader"));
        return scheduleService.getAllSchedules();
    }
}
