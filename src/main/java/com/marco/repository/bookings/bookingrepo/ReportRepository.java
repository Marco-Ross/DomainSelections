package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.Report;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface ReportRepository extends RepositoryGI<Report, Integer> {
    ArrayList<Report> getAllReports();
}
