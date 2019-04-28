package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.Report;
import com.marco.factory.bookings.RefundFactory;
import com.marco.factory.bookings.ReportFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.ReportRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReportRepositoryImplTest {
    private ReportRepository repository;
    private Report report;

    @Before
    public void setUp() throws Exception {
        this.repository = ReportRepositoryImpl.getRepository();
        report = ReportFactory.getReport(400, 200, 20);
        this.repository.create(report);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Report> arrayList = repository.getAllReports();
        arrayList.clear();
    }

    @Test
    public void getAllReports() {
        ArrayList<Report> arrayList = repository.getAllReports();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Report report = ReportFactory.getReport(400, 200, 31);
        Report reportTest = this.repository.create(report);

        Assert.assertEquals(report, reportTest);
    }

    @Test
    public void update() {
        Report report = ReportFactory.getReport(600, 300, 20);
        this.repository.update(report);

        ArrayList<Report> reports = repository.getAllReports();
        Assert.assertTrue(reports.contains(report));
        System.out.println("Report updated");
    }

    @Test
    public void delete() {
        repository.delete(report);
        ArrayList<Report> reports = repository.getAllReports();
        Assert.assertEquals(0, reports.size());
    }

    @Test
    public void read() {
        Report reportList = repository.read(20);
        Assert.assertEquals(reportList, report);
    }
}