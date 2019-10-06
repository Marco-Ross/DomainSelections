package com.marco.controller.actors;

import com.marco.domain.actors.Security;
import com.marco.service.actors.actorservice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/actor/security")
public class SecurityController {
    @Autowired
    @Qualifier("SecurityServiceImpl")
    private SecurityService service;

    @PostMapping("/create")
    @ResponseBody
    public Security create(@RequestBody Security security){
        return service.create(security);
    }

    @PutMapping("/update")
    @ResponseBody
    public Security update(@RequestBody Security security){
        return service.update(security);
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
    public Set<Security> getAllSecurity(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("SecurityHeader"));
        return service.getAllSecurity();
    }
}
