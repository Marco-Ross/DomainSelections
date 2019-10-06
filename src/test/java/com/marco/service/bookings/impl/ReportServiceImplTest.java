package com.marco.service.bookings.impl;

import com.marco.domain.bookings.Report;
import com.marco.factory.bookings.ReportFactory;
import com.marco.service.bookings.bookingservice.ReportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportServiceImplTest {
    @Autowired
    @Qualifier("ReportServiceImpl")
    private ReportService service;
    private Report report;

    private Report getRepo(){
        for(Report reportA : service.getAllReports()){
            if(reportA.getReportID() == report.getReportID()){
                return reportA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        report = ReportFactory.buildReport(400, 200, 20);
    }

    @Test
    public void d_getAllReports() {
        ArrayList<Report> arrayList = service.getAllReports();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Report reportTest = this.service.create(report);
        Assert.assertEquals(report.getReportID(), reportTest.getReportID());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        double profit = 500;
        Report updated = new Report.Builder().copy(getRepo()).profit(profit).build();

        this.service.update(updated);

        Assert.assertEquals(profit, updated.getProfit(), 0.1);
        System.out.println("Report updated");
    }

    @Test
    public void e_delete() {
        service.delete(report.getReportID());
        ArrayList<Report> reports = service.getAllReports();
        Assert.assertEquals(0, reports.size());
    }

    @Test
    public void b_read() {
        Optional<Report> reportRead = service.read(400);
        Assert.assertTrue(reportRead.isPresent());
        Assert.assertEquals(report.getReportID(), reportRead.get().getReportID());
    }
}