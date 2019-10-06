package com.marco.controller.transit;

import com.marco.domain.transit.Station;
import com.marco.service.transit.transitservice.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/station")
public class StationController {
    @Autowired
    @Qualifier("StationServiceImpl")
    private StationService service;

    @PostMapping("/create")
    @ResponseBody
    public Station create(@RequestBody Station station){
        return service.create(station);
    }

    @PutMapping("/update")
    @ResponseBody
    public Station update(@RequestBody Station station){
        return service.update(station);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Optional read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Station> getAllStations(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("StationHeader"));
        return service.getAllStations();
    }
}
