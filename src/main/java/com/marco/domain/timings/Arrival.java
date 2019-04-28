package com.marco.domain.timings;

import java.util.Date;

public class Arrival {
    private int arrivalId;
    private String arrivalStation;

    private Arrival() {
    }

    private Arrival(Builder builder){
        this.arrivalId = builder.arrivalId;
        this.arrivalStation = builder.arrivalStation;
    }

    public int getArrivalId() {
        return arrivalId;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public static class Builder{
        private int arrivalId;
        private String arrivalStation;

        public Builder arrivalId(int arrivalId){
            this.arrivalId = arrivalId;
            return this;
        }
        public Builder arrivalStation(String arrivalStation){
            this.arrivalStation = arrivalStation;
            return this;
        }

        public Arrival build(){return new Arrival(this);}
    }
}
