package com.marco.controller.bookings;

import com.marco.domain.bookings.Report;
import com.marco.service.bookings.bookingservice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/railway/report")
public class ReportController {
    @Autowired
    @Qualifier("ReportServiceImpl")
    private ReportService service;

    @PostMapping("/create")
    @ResponseBody
    public Report create(@RequestBody Report report){
        return service.create(report);
    }

    @PutMapping("/update")
    @ResponseBody
    public Report update(@RequestBody Report report){
        return service.update(report);
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
    public ArrayList<Report> getAllReports(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ReportHeader"));
        return service.getAllReports();
    }
}
