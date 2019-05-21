package com.marco.domain.bookings;

public class Report {
    private double revenue;
    private double profit;
    private int reportID;

    private Report() {
    }

    private Report(Builder builder){
        this.revenue = builder.revenue;
        this.profit = builder.profit;
        this.reportID = builder.reportID;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getProfit() {
        return profit;
    }

    public int getReportID() {
        return reportID;
    }

    public static class Builder{
        private double revenue;
        private double profit;
        private int reportID;

        public Builder revenue(double revenue){
            this.revenue = revenue;
            return this;
        }

        public Builder profit(double profit){
            this.profit = profit;
            return this;
        }

        public Builder reportID(int reportID){
            this.reportID = reportID;
            return this;
        }

        public Builder copy(Report report){
            this.revenue = report.revenue;
            this.profit = report.profit;
            this.reportID = report.reportID;

            return this;
        }

        public Report build(){return new Report(this);}
    }
}
