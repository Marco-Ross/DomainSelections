//package com.marco.repository.bookings.bookingrepo;
//
//import com.marco.domain.bookings.Report;
//import com.marco.factory.bookings.ReportFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ReportRepositoryImplTest {
//    @Autowired
//    private ReportRepository repository;
//    private Report report;
//
//    private Report getRepo(){
//        for(Report reportA : repository.findAll()){
//            if(reportA.getReportID() == report.getReportID()){
//                return reportA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        report = ReportFactory.buildReport(400, 200, 20);
//    }
//
//    @Test
//    public void d_getAllReports() {
//        ArrayList<Report> arrayList = (ArrayList<Report>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Report reportTest = this.repository.save(report);
//        Assert.assertEquals(report, reportTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        double profit = 500;
//        Report updated = new Report.Builder().copy(getRepo()).profit(profit).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(profit, updated.getProfit(), 0.1);
//        System.out.println("Report updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(report.getReportID());
//        ArrayList<Report> reports = (ArrayList<Report>) repository.findAll();
//        Assert.assertEquals(0, reports.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Report> reportRead = repository.findById(20);
//        Assert.assertTrue(reportRead.isPresent());
//        Assert.assertEquals(report.getReportID(), reportRead.get().getReportID());
//    }
//}