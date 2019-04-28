package com.marco.repository.repositoryinterfaces.bookingrepo;

import com.marco.domain.bookings.Report;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface ReportRepository extends RepositoryGI<Report, Integer> {
    ArrayList<Report> getAllReports();
}
