package com.marco.controller.actors;

import com.marco.domain.actors.Manager;
import com.marco.service.actors.actorservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/railway/actor/manager")
public class ManagerController {
    @Autowired
    @Qualifier("ManagerServiceImpl")
    private ManagerService service;

    @PostMapping("/create")
    @ResponseBody
    public Manager create(@RequestBody Manager manager){
        return service.create(manager);
    }

    @PutMapping("/update")
    @ResponseBody
    public Manager update(@RequestBody Manager manager){
        return service.update(manager);
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
    public ArrayList<Manager> getAllManagers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ManagerHeader"));
        return service.getAllManagers();
    }
}
