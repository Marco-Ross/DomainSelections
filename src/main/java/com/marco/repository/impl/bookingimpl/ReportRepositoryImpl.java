package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.Report;
import com.marco.repository.repositoryinterfaces.bookingrepo.ReportRepository;

import java.util.ArrayList;

public class ReportRepositoryImpl implements ReportRepository {
    private static ReportRepositoryImpl repository = null;
    private ArrayList<Report> reports;

    private ReportRepositoryImpl(){
        this.reports = new ArrayList<>();
    }

    public static ReportRepositoryImpl getRepository(){
        if(repository == null) repository = new ReportRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Report> getAllReports() {
        return this.reports;
    }

    @Override
    public Report create(Report report) {
        this.reports.add(report);
        return report;
    }

    @Override
    public Report update(Report report) {
        for(int i = 0; i<reports.size();i++){
            if(report.getReportID() == reports.get(i).getReportID()){
                this.reports.set(i, report);
            }
        }
        return report;
    }

    @Override
    public void delete(Report report) {
        this.reports.remove(report);
    }

    @Override
    public Report read(Integer reportID) {
        Report report = null;
        for(Report reportA : reports){
            if(reportID == reportA.getReportID()){
                report = reportA;
            }
        }
        return report;
    }
}
