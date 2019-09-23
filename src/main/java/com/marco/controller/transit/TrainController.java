package com.marco.controller.transit;

import com.marco.domain.transit.Station;
import com.marco.domain.transit.Train;
import com.marco.service.transit.transitservice.StationService;
import com.marco.service.transit.transitservice.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/railway/train")
public class TrainController {
    @Autowired
    @Qualifier("TrainServiceImpl")
    private TrainService service;

    @PostMapping("/create")
    @ResponseBody
    public Train create(@RequestBody Train train){
        return service.create(train);
    }

    @PutMapping("/update")
    @ResponseBody
    public Train update(@RequestBody Train train){
        return service.update(train);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Train read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Train> getAllTrains(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("TrainHeader"));
        return service.getAllTrains();
    }
}
