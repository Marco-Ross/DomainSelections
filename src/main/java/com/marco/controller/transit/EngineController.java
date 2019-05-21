package com.marco.controller.transit;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Engine;
import com.marco.service.transit.transitservice.DelayService;
import com.marco.service.transit.transitservice.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/engine")
public class EngineController {
    @Autowired
    @Qualifier("EngineServiceImpl")
    private EngineService service;

    @PostMapping("/create")
    @ResponseBody
    public Engine create(@RequestBody Engine engine){
        return service.create(engine);
    }

    @PutMapping("/update")
    @ResponseBody
    public Engine update(@RequestBody Engine engine){
        return service.update(engine);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Engine read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Engine> getAllEngines(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("EngineHeader"));
        return service.getAllEngines();
    }
}
