package com.marco.controller.actors;

import com.marco.domain.actors.TicketClerk;
import com.marco.service.actors.actorservice.TicketClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/actor/ticketclerk")
public class TicketClerkController {
    @Autowired
    @Qualifier("TicketClerkServiceImpl")
    private TicketClerkService service;

    @PostMapping("/create")
    @ResponseBody
    public TicketClerk create(@RequestBody TicketClerk ticketClerk){
        return service.create(ticketClerk);
    }

    @PutMapping("/update")
    @ResponseBody
    public TicketClerk update(@RequestBody TicketClerk ticketClerk){
        return service.update(ticketClerk);
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
    public Set<TicketClerk> getAllTicketClerks(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("TicketClerkHeader"));
        return service.getAllTicketClerks();
    }
}
