package com.marco.controller.bookings;

import com.marco.domain.bookings.BookingStatus;
import com.marco.service.bookings.bookingservice.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/railway/bookingstatus")
public class BookingStatusController {
    @Autowired
    @Qualifier("BookingStatusServiceImpl")
    private BookingStatusService service;

    @PostMapping("/create")
    @ResponseBody
    public BookingStatus create(@RequestBody BookingStatus bookingStatus){
        return service.create(bookingStatus);
    }

    @PutMapping("/update")
    @ResponseBody
    public BookingStatus update(@RequestBody BookingStatus bookingStatus){
        return service.update(bookingStatus);
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
    public Set<BookingStatus> getAllBookingStatus(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("BookingStatusHeader"));
        return service.getAllBookingStatus();
    }
}
