package com.marco.domain.timings;

import java.util.Date;

public class Departure {
    private Date departureTime;
    private String departureStation;

    private Departure() {
    }

    private Departure(Builder builder){
        this.departureTime = builder.departureTime;
        this.departureStation = builder.departureStation;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public static class Builder{
        private Date departureTime;
        private String departureStation;

        public Builder departureTime(Date departureTime){
            this.departureTime = departureTime;
            return this;
        }

        public Builder departureStation(String departureStation){
            this.departureStation = departureStation;
            return this;
        }

        public Departure build(){return new Departure(this);}
    }
}
