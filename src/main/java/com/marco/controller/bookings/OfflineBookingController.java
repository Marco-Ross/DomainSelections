package com.marco.controller.bookings;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.service.bookings.bookingservice.OfflineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/offlinebooking")
public class OfflineBookingController {
    @Autowired
    @Qualifier("OfflineBookingServiceImpl")
    private OfflineBookingService service;

    @PostMapping("/create")
    @ResponseBody
    public OfflineBooking create(@RequestBody OfflineBooking offlineBooking){
        return service.create(offlineBooking);
    }

    @PutMapping("/update")
    @ResponseBody
    public OfflineBooking update(@RequestBody OfflineBooking offlineBooking){
        return service.update(offlineBooking);
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
    public Set<OfflineBooking> getAllOfflineBookings(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("OfflineBookingHeader"));
        return service.getAllOfflineBookings();
    }
}
