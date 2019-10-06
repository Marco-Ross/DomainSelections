//package com.marco.repository.bookings.impl;
//
//import com.marco.domain.bookings.Report;
//import com.marco.repository.bookings.bookingrepo.ReportRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//
//@Repository("ReportRepoImpl")
//public class ReportRepositoryImpl implements ReportRepository {
//    private ArrayList<Report> reports;
//
//    private ReportRepositoryImpl(){
//        this.reports = new ArrayList<>();
//    }
//
//    @Override
//    public ArrayList<Report> getAllReports() {
//        return this.reports;
//    }
//
//    @Override
//    public Report create(Report report) {
//        this.reports.add(report);
//        for(Report reportA : reports){
//            if(report == reportA){
//                return reportA;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Report update(Report report) {
//        for(int i = 0; i<reports.size();i++){
//            if(report.getReportID() == reports.get(i).getReportID()){
//                this.reports.set(i, report);
//                return report;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Integer reportID) {
//        for(Report reportA : reports){
//            if(reportID == reportA.getReportID()){
//                this.reports.remove(reportA);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public Report read(Integer reportID) {
//        for(Report reportA : reports){
//            if(reportID == reportA.getReportID()){
//                return reportA;
//            }
//        }
//        return null;
//    }
//}
