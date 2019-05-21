package com.marco.controller.transit;

import com.marco.domain.transit.Engine;
import com.marco.domain.transit.Platform;
import com.marco.service.transit.transitservice.EngineService;
import com.marco.service.transit.transitservice.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/platform")
public class PlatformController {
    @Autowired
    @Qualifier("PlatformServiceImpl")
    private PlatformService service;

    @PostMapping("/create")
    @ResponseBody
    public Platform create(@RequestBody Platform platform){
        return service.create(platform);
    }

    @PutMapping("/update")
    @ResponseBody
    public Platform update(@RequestBody Platform platform){
        return service.update(platform);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Platform read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Platform> getAllPlatforms(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("PlatformHeader"));
        return service.getAllPlatforms();
    }
}
