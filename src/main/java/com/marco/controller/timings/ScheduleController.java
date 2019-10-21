package com.marco.controller.timings;

import com.marco.domain.timings.clientobject.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.timings.compositeclass.TrainSchedule;
import com.marco.domain.timings.compositeclass.TrainScheduleId;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
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
import java.util.List;

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

        Train trainReceived = trainService.getTrainWithTrainNumber(newSchedule.getTrainNumber());
        for (TrainSchedule trainSchedule : trainScheduleService.getAllTrainSchedules()) {
            if (trainReceived.getTrainID() == trainSchedule.getTrainID()) {
                for (Schedule schedule : scheduleService.getAllSchedules()) {
                    if (schedule.getScheduleID() == trainSchedule.getScheduleID()) {
                        if(schedule.getDeparture().equals(newSchedule.getDeparture()) && schedule.getDepartureDate().equals(newSchedule.getDepartureDate())){
                            return null;
                        }
                    }
                }
            }
        }

        Schedule schedule = ScheduleFactory.buildSchedule(newSchedule.getDepartureDate(), newSchedule.getDeparture(), newSchedule.getArrival());
        Schedule savedSchedule = scheduleService.create(schedule);

        Train train = trainService.getTrainWithTrainNumber(newSchedule.getTrainNumber());

        trainService.update(train);

        TrainSchedule trainSchedule = TrainScheduleFactory.buildTrainSchedule(schedule.getScheduleID(), train.getTrainID());
        trainScheduleService.create(trainSchedule);

        return savedSchedule;
    }

    @PutMapping("/update")
    @ResponseBody
    public Train update(@RequestBody NewSchedule newSchedule){
        Schedule scheduleRequested = scheduleService.getScheduleWithTrainNumber(newSchedule.getTrainNumber());
        Train trainRequested = trainService.getTrainWithTrainNumber(newSchedule.getTrainNumber());

        Schedule schedule = new Schedule.Builder().copy(scheduleRequested).departureDate(newSchedule.getDepartureDate()).departure(newSchedule.getDeparture()).arrival(newSchedule.getArrival()).build();
        Train train = new Train.Builder().copy(trainRequested).capacity(newSchedule.getCapacity()).build();

        Train t= trainService.update(train);
        scheduleService.update(schedule);

        return t;
    }

    @DeleteMapping("/delete/{trainNumber}/{departureDate}/{departureTime}")
    @ResponseBody
    public void delete(@PathVariable Integer trainNumber, @PathVariable String departureDate, @PathVariable String departureTime){

        Train trainReceived = trainService.getTrainWithTrainNumber(trainNumber);

        for (TrainSchedule trainSchedule : trainScheduleService.getAllTrainSchedules()) {
            if (trainReceived.getTrainID() == trainSchedule.getTrainID()) {
                for (Schedule schedule : scheduleService.getAllSchedules()) {
                    if (schedule.getScheduleID() == trainSchedule.getScheduleID()) {
                        if(schedule.getDeparture().equals(departureTime) && schedule.getDepartureDate().equals(departureDate)){

                            Schedule schedule2 = scheduleService.getScheduleWithTrainNumber(trainNumber);
                            Train trainRequested = trainService.getTrainWithTrainNumber(trainNumber);

                            TrainScheduleId trainScheduleId = new TrainScheduleId();
                            trainScheduleId.setScheduleID(schedule2.getScheduleID());
                            trainScheduleId.setTrainID(trainRequested.getTrainID());

                            scheduleService.delete(schedule2.getScheduleID());
                            trainService.delete(trainNumber);
                            trainScheduleService.delete(trainScheduleId);
                        }
                    }
                }
            }
        }
    }

    @GetMapping("/readTime/{date}/{time}")
    @ResponseBody
    public List<NewSchedule> readTime(@PathVariable String date, @PathVariable String time){
        return trainScheduleService.readTime(date, time);
    }

    @GetMapping("/readTrain/{trainNumber}")
    @ResponseBody
    public NewSchedule readTrain(@PathVariable int trainNumber){
        return trainScheduleService.readTrain(trainNumber);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<NewSchedule> getAllSchedules(@RequestHeader HttpHeaders headers){
        return scheduleService.getAllTrainSchedules();
    }
}
