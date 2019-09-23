package com.marco.controller.actors;

import com.marco.domain.actors.DoorMan;
import com.marco.service.actors.actorservice.DoorManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/railway/actor/doorman")
public class DoorManController {
    @Autowired
    @Qualifier("DoorManServiceImpl")
    private DoorManService service;

    @PostMapping("/create")
    @ResponseBody
    public DoorMan create(@RequestBody DoorMan doorMan){
        return service.create(doorMan);
    }

    @PutMapping("/update")
    @ResponseBody
    public DoorMan update(@RequestBody DoorMan doorMan){
        return service.update(doorMan);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public DoorMan read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<DoorMan> getAllDrivers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("DoorManHeader"));
        return service.getAllDoorMen();
    }
}
