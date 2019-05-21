package com.marco.controller.actors;

import com.marco.domain.actors.Announcer;
import com.marco.factory.actors.AnnouncerFactory;
import com.marco.service.actors.actorservice.AnnouncerService;
import com.marco.service.actors.impl.AnnouncerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//(@RestController) = Stereotype for presentation layer (Combination of @Controller & @ResponseBody)
//Different from web application in that the response for web app is generally(HTML,CSS,JavaScript), whereas REST API just returns data in the form of JSON or XML because most REST clients are programs
@RestController
@RequestMapping("/railway/announcer")
public class AnnouncerController {

    @Autowired
    @Qualifier("AnnouncerServiceImpl") //Specifies implementation (not needed since there is no other impl for serviceImpl)
    private AnnouncerService service;

    @PostMapping("/create")
    @ResponseBody //returns the [service.create(announcer)]'s returned object back into the HttpResponse object as a serialized JSON. The test will read it in as ResponseEntity<Announcer>, object Inside body
    public Announcer create(@RequestBody Announcer announcer){
        return service.create(announcer);
    }

    @PutMapping("/update")
    @ResponseBody //Update is using the Second impl of Repository and adding ("SecondImpl" after surname)
    public Announcer update(@RequestBody Announcer announcer){
        return service.update(announcer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Announcer read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Announcer> getAllAnnouncers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("AnnouncerHeader"));
        return service.getAllAnnouncers();
    }
}