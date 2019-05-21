package com.marco.controller.timings;

import com.marco.domain.credentials.Profile;
import com.marco.domain.timings.Schedule;
import com.marco.service.credentials.credentialservice.ProfileService;
import com.marco.service.timings.timingservice.ScheduleService;
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
    private ScheduleService service;

    @PostMapping("/create")
    @ResponseBody
    public Schedule create(@RequestBody Schedule schedule){
        return service.create(schedule);
    }

    @PutMapping("/update")
    @ResponseBody
    public Schedule update(@RequestBody Schedule schedule){
        return service.update(schedule);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Schedule read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Schedule> getAllSchedules(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ScheduleHeader"));
        return service.getAllSchedules();
    }
}
