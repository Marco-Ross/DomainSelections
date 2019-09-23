package com.marco.controller.transit;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Carriage;
import com.marco.service.timings.timingservice.ScheduleService;
import com.marco.service.transit.transitservice.CarriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/carriage")
public class CarriageController {
    @Autowired
    @Qualifier("CarriageServiceImpl")
    private CarriageService service;

    @PostMapping("/create")
    @ResponseBody
    public Carriage create(@RequestBody Carriage carriage){
        return service.create(carriage);
    }

    @PutMapping("/update")
    @ResponseBody
    public Carriage update(@RequestBody Carriage carriage){
        return service.update(carriage);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Carriage read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Carriage> getAllCarriages(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("CarriageHeader"));
        return service.getAllCarriages();
    }
}
