package com.marco.service.bookings.impl;

import com.marco.domain.bookings.Report;
import com.marco.repository.bookings.bookingrepo.ReportRepository;
import com.marco.repository.bookings.impl.ReportRepositoryImpl;
import com.marco.service.bookings.bookingservice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ReportServiceImpl")
public class ReportServiceImpl implements ReportService {
    @Autowired
    @Qualifier("ReportRepoImpl")
    private ReportRepository repository;

    @Override
    public ArrayList<Report> getAllReports() {
        return this.repository.getAllReports();
    }

    @Override
    public Report create(Report report) {
        return this.repository.create(report);
    }

    @Override
    public Report update(Report report) {
        return this.repository.update(report);
    }

    @Override
    public void delete(Integer report) {
        this.repository.delete(report);
    }

    @Override
    public Report read(Integer report) {
        return this.repository.read(report);
    }
}
