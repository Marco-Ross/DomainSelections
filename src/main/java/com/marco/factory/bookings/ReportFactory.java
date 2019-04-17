package com.marco.factory.bookings;

import com.marco.domain.bookings.Report;

public class ReportFactory {
    public static Report getReport(double revenue, double profit){
        return new Report.Builder().revenue(revenue)
                .profit(profit)
                .build();
    }
}
