package com.marco.factory.bookings;

import com.marco.domain.bookings.Report;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportFactoryTest {

    @Test
    public void getReport() {
        int reportID = 20;
        double revenue = 400.50;
        double profit = 300;

        Report report = ReportFactory.buildReport(reportID, revenue, profit);
        assertEquals(profit, report.getProfit(), 0.1);
    }
}