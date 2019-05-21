package com.marco.factory.bookings;

import com.marco.domain.bookings.Report;

public class ReportFactory {
    public static Report buildReport(double revenue, double profit, int reportID){
        return new Report.Builder().revenue(revenue)
                .profit(profit)
                .reportID(reportID)
                .build();
    }
}
