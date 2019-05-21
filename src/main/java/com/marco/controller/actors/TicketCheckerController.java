package com.marco.controller.actors;

import com.marco.domain.actors.Security;
import com.marco.domain.actors.TicketChecker;
import com.marco.service.actors.actorservice.SecurityService;
import com.marco.service.actors.actorservice.TicketCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/ticketchecker")
public class TicketCheckerController {
    @Autowired
    @Qualifier("TicketCheckerServiceImpl")
    private TicketCheckerService service;

    @PostMapping("/create")
    @ResponseBody
    public TicketChecker create(@RequestBody TicketChecker ticketChecker){
        return service.create(ticketChecker);
    }

    @PutMapping("/update")
    @ResponseBody
    public TicketChecker update(@RequestBody TicketChecker ticketChecker){
        return service.update(ticketChecker);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TicketChecker read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<TicketChecker> getAllTicketCheckers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("SecurityHeader"));
        return service.getAllTicketCheckers();
    }
}
