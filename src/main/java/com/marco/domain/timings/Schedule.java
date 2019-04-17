package com.marco.domain.timings;

import java.util.Date;

public class Schedule {
    private String trainLocation;
    private Date trainDelays;

    private Schedule() {
    }

    private Schedule(Builder builder){
        this.trainLocation = builder.trainLocation;
        this.trainDelays = builder.trainDelays;
    }

    public String getTrainLocation() {
        return trainLocation;
    }

    public Date getTrainDelays() {
        return trainDelays;
    }

    public static class Builder{
        private String trainLocation;
        private Date trainDelays;

        public Builder trainLocation(String trainLocation){
            this.trainLocation = trainLocation;
            return this;
        }

        public Builder trainDelays(Date trainDelays){
            this.trainDelays = trainDelays;
            return this;
        }

        public Schedule build(){return new Schedule(this);}
    }
}
