package com.marco.domain.timings;

import com.marco.domain.transit.Train;

import java.util.Date;

public class Schedule {
    private Date arrival;
    private Date departure;
    private Train train;

    private Schedule() {
    }

    private Schedule(Builder builder){
        this.departure = builder.departure;
        this.arrival = builder.arrival;
        this.train = builder.train;
    }

    public Train getTrain(){
        return train;
    }
    public int getTrainNumber() {
        return train.getTrainNumber();
    }

    public static class Builder{
        private Date arrival;
        private Date departure;
        private Train train;

        public Builder departure(Date departure){
            this.departure = departure;
            return this;
        }

        public Builder arrival(Date arrival){
            this.arrival = arrival;
            return this;
        }

        public Builder train(Train train){
            this.train = train;
            return this;
        }

        public Schedule build(){return new Schedule(this);}
    }
}
