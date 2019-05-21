package com.marco.controller.transit;

import com.marco.domain.transit.Platform;
import com.marco.domain.transit.Route;
import com.marco.service.transit.transitservice.PlatformService;
import com.marco.service.transit.transitservice.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/railway/route")
public class RouteController {
    @Autowired
    @Qualifier("RouteServiceImpl")
    private RouteService service;

    @PostMapping("/create")
    @ResponseBody
    public Route create(@RequestBody Route route){
        return service.create(route);
    }

    @PutMapping("/update")
    @ResponseBody
    public Route update(@RequestBody Route route){
        return service.update(route);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Route read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Route> getAllRoutes(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("RouteHeader"));
        return service.getAllRoutes();
    }
}
