package com.marco.domain.timings;

import java.util.Date;

public class Departure {
    private Date estimatedDepartureTime;
    private String departureStation;

    private Departure() {
    }

    private Departure(Builder builder){
        this.estimatedDepartureTime = builder.estimatedDepartureTime;
        this.departureStation = builder.departureStation;
    }

    public Date getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public static class Builder{
        private Date estimatedDepartureTime;
        private String departureStation;

        public Builder estimatedDepartureTime(Date estimatedDepartureTime){
            this.estimatedDepartureTime = estimatedDepartureTime;
            return this;
        }

        public Builder departureStation(String departureStation){
            this.departureStation = departureStation;
            return this;
        }

        public Departure build(){return new Departure(this);}
    }
}
