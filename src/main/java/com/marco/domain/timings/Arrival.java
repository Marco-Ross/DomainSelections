package com.marco.domain.timings;

import java.util.Date;

public class Arrival {
    private Date estimatedArrivalTime;
    private String arrivalStation;

    private Arrival() {
    }

    private Arrival(Builder builder){
        this.estimatedArrivalTime = builder.estimatedArrivalTime;
        this.arrivalStation = builder.arrivalStation;
    }

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public static class Builder{
        private Date estimatedArrivalTime;
        private String arrivalStation;

        public Builder estimatedArrivalTime(Date estimatedArrivalTime){
            this.estimatedArrivalTime = estimatedArrivalTime;
            return this;
        }

        public Builder arrivalStation(String arrivalStation){
            this.arrivalStation = arrivalStation;
            return this;
        }

        public Arrival build(){return new Arrival(this);}
    }
}
