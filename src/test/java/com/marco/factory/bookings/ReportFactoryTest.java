package com.marco.factory.bookings;

import com.marco.domain.bookings.Report;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportFactoryTest {

    @Test
    public void getReport() {
        double revenue = 400.50;
        double profit = 300;
        Report report = ReportFactory.getReport(revenue, profit);
        assertNotEquals(report.getProfit(), report.getRevenue());
    }
}