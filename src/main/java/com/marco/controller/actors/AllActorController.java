package com.marco.controller.actors;

import com.marco.domain.actors.*;
import com.marco.service.actors.actorservice.*;
import com.marco.service.actors.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/railway/actor/allactors")
public class AllActorController {
    @Autowired
    private AnnouncerServiceImpl announcerService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private DoorManServiceImpl doorManService;

    @Autowired
    private DriverServiceImpl driverService;

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private TicketCheckerServiceImpl ticketCheckerService;

    @Autowired
    private TicketClerkServiceImpl ticketClerkService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Object> getAllActors(@RequestHeader HttpHeaders headers){
        List<Object> allActorsList = new ArrayList<>();

        allActorsList.addAll(announcerService.getAllAnnouncers());
        allActorsList.addAll(customerService.getAllCustomers());
        allActorsList.addAll(doorManService.getAllDoorMen());
        allActorsList.addAll(driverService.getAllDrivers());
        allActorsList.addAll(securityService.getAllSecurity());
        allActorsList.addAll(ticketCheckerService.getAllTicketCheckers());
        allActorsList.addAll(ticketClerkService.getAllTicketClerks());

        return allActorsList;
    }

    @GetMapping("/getEmp/{empNum}")
    @ResponseBody
    public Object getEmp(@PathVariable int empNum){

        if(announcerService.read(empNum).isPresent()){
            return announcerService.read(empNum).get();
        }
        if(customerService.read(empNum).isPresent()){
            return customerService.read(empNum).get();
        }
        if(doorManService.read(empNum).isPresent()){
            return doorManService.read(empNum).get();
        }
        if(driverService.read(empNum).isPresent()){
            return driverService.read(empNum).get();
        }
        if(securityService.read(empNum).isPresent()){
            return securityService.read(empNum).get();
        }
        if(ticketCheckerService.read(empNum).isPresent()){
            return ticketCheckerService.read(empNum).get();
        }
        if(ticketClerkService.read(empNum).isPresent()){
            return ticketClerkService.read(empNum).get();
        }
        return null;
    }


    @DeleteMapping("/deleteEmp/{empNum}")
    @ResponseBody
    public void deleteEmp(@PathVariable int empNum){
        if(announcerService.read(empNum).isPresent()){
            announcerService.delete(empNum);
        }
        if(customerService.read(empNum).isPresent()){
            customerService.delete(empNum);
        }
        if(doorManService.read(empNum).isPresent()){
            doorManService.delete(empNum);
        }
        if(driverService.read(empNum).isPresent()){
            driverService.delete(empNum);
        }
        if(securityService.read(empNum).isPresent()){
            securityService.delete(empNum);
        }
        if(ticketCheckerService.read(empNum).isPresent()){
            ticketCheckerService.delete(empNum);
        }
        if(ticketClerkService.read(empNum).isPresent()){
            ticketClerkService.delete(empNum);
        }
    }

    @DeleteMapping("/deleteAll")
    @ResponseBody
    public void deleteAllActors(@RequestHeader HttpHeaders headers){
        List<Object> allActorsList = new ArrayList<>();

        announcerService.deleteAll();
        customerService.deleteAll();
        doorManService.deleteAll();
        driverService.deleteAll();
        securityService.deleteAll();
        ticketCheckerService.deleteAll();
        ticketClerkService.deleteAll();
    }

    @PutMapping("/updateEmp")
    @ResponseBody
    public Object updateEmp(@PathVariable Object emp){

        if(emp instanceof Announcer){
            return announcerService.update((Announcer) emp);
        }
        if(emp instanceof DoorMan){
            return doorManService.update((DoorMan)emp);
        }
        if(emp instanceof Driver){
            return driverService.update((Driver)emp);
        }
        if(emp instanceof Security){
            return securityService.update((Security)emp);
        }
        if(emp instanceof TicketChecker){
            return ticketCheckerService.update((TicketChecker)emp);
        }
        if(emp instanceof TicketClerk){
            return ticketClerkService.update((TicketClerk)emp);
        }
        return null;
    }

}
