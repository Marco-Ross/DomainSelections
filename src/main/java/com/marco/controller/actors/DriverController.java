package com.marco.controller.actors;

import com.marco.domain.actors.Customer;
import com.marco.domain.actors.Driver;
import com.marco.service.actors.actorservice.CustomerService;
import com.marco.service.actors.actorservice.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/railway/actor/driver")
public class DriverController {
    @Autowired
    @Qualifier("DriverServiceImpl")
    private DriverService service;

    @PostMapping("/create")
    @ResponseBody
    public Driver create(@RequestBody Driver driver){
        return service.create(driver);
    }

    @PutMapping("/update")
    @ResponseBody
    public Driver update(@RequestBody Driver driver){
        return service.update(driver);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Driver read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Driver> getAllDrivers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("DriverHeader"));
        return service.getAllDrivers();
    }
}
