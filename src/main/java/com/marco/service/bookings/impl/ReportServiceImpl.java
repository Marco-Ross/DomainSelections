package com.marco.service.bookings.impl;

import com.marco.domain.bookings.Report;
import com.marco.repository.bookings.bookingrepo.ReportRepository;
import com.marco.service.bookings.bookingservice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("ReportServiceImpl")
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository repository;

    @Override
    public ArrayList<Report> getAllReports() {
        return (ArrayList<Report>) this.repository.findAll();
    }

    @Override
    public Report create(Report report) {
        return this.repository.save(report);
    }

    @Override
    public Report update(Report report) {
        return this.repository.save(report);
    }

    @Override
    public void delete(Integer report) {
        this.repository.deleteById(report);
    }

    @Override
    public Optional<Report> read(Integer report) {
        return this.repository.findById(report);
    }
}
