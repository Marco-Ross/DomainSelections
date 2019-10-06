package com.marco.controller.bookings;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.service.bookings.bookingservice.OnlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/onlinebooking")
public class OnlineBookingController {
    @Autowired
    @Qualifier("OnlineBookingServiceImpl")
    private OnlineBookingService service;

    @PostMapping("/create")
    @ResponseBody
    public OnlineBooking create(@RequestBody OnlineBooking onlineBooking){
        return service.create(onlineBooking);
    }

    @PutMapping("/update")
    @ResponseBody
    public OnlineBooking update(@RequestBody OnlineBooking onlineBooking){
        return service.update(onlineBooking);
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
    public ArrayList<OnlineBooking> getAllOnlineBookings(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("OnlineBookingHeader"));
        return service.getAllOnlineBookings();
    }
}
