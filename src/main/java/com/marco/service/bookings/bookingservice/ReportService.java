package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.Report;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface ReportService extends ServiceGI<Report, Integer, Optional<Report>> {
    ArrayList<Report> getAllReports();
}
