package com.marco.controller.transit;

import com.marco.domain.transit.Carriage;
import com.marco.domain.transit.Delay;
import com.marco.service.transit.transitservice.CarriageService;
import com.marco.service.transit.transitservice.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/railway/delay")
public class DelayController {
    @Autowired
    @Qualifier("DelayServiceImpl")
    private DelayService service;

    @PostMapping("/create")
    @ResponseBody
    public Delay create(@RequestBody Delay delay){
        return service.create(delay);
    }

    @PutMapping("/update")
    @ResponseBody
    public Delay update(@RequestBody Delay delay){
        return service.update(delay);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Delay read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Delay> getAllDelays(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("DelayHeader"));
        return service.getAllDelays();
    }
}
