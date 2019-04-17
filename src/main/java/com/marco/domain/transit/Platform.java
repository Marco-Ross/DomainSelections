package com.marco.domain.transit;

import java.util.Date;

public class Platform {
    private int platformNumber;
    private Date platformTrainArrivalTime;

    private Platform() {
    }

    private Platform(Builder builder){
        this.platformNumber = builder.platformNumber;
        this.platformTrainArrivalTime = builder.platformTrainArrivalTime;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public Date getPlatformTrainArrivalTime() {
        return platformTrainArrivalTime;
    }

    public static class Builder{
        private int platformNumber;
        private Date platformTrainArrivalTime;

        public Builder platformNumber(int platformNumber){
            this.platformNumber = platformNumber;
            return this;
        }

        public Builder platformTrainArrivalTime(Date platformTrainArrivalTime){
            this.platformTrainArrivalTime = platformTrainArrivalTime;
            return this;
        }

        public Platform build(){return new Platform(this);}
    }
}
