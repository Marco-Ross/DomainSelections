package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.Report;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface ReportService extends ServiceGI<Report, Integer> {
    ArrayList<Report> getAllReports();
}
