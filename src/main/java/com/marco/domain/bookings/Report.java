package com.marco.domain.bookings;

public class Report {
    private double revenue;
    private double profit;

    private Report() {
    }

    private Report(Builder builder){
        this.revenue = builder.revenue;
        this.profit = builder.profit;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getProfit() {
        return profit;
    }

    public static class Builder{
        private double revenue;
        private double profit;

        public Builder revenue(double revenue){
            this.revenue = revenue;
            return this;
        }

        public Builder profit(double profit){
            this.profit = profit;
            return this;
        }

        public Report build(){return new Report(this);}
    }
}
