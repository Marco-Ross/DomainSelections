package com.marco.controller.actors;

import com.marco.domain.actors.Announcer;
import com.marco.domain.actors.Customer;
import com.marco.service.actors.actorservice.CustomerService;
import com.marco.service.actors.impl.AnnouncerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/railway/actor/customer")
public class CustomerController {
    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService service;

    @PostMapping("/create")
    @ResponseBody
    public Customer create(@RequestBody Customer customer, @RequestHeader HttpHeaders headers){
        return service.create(customer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer){
        return service.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Customer read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<Customer> getAllCustomers(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("CustomerHeader"));
        return service.getAllCustomers();
    }
}
