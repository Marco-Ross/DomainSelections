package com.marco.domain.timings.compositeclass;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.IdClass;

@Entity
@IdClass(TrainScheduleId.class)
public class TrainSchedule {
    @Id
    private int scheduleID;
    @Id
    private int trainID;

    private TrainSchedule(){}

    private TrainSchedule(Builder builder){
        this.scheduleID = builder.scheduleID;
        this.trainID = builder.trainID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public int getTrainID() {
        return trainID;
    }

    public static class Builder{
        private int scheduleID;
        private int trainID;

        public Builder scheduleID(int scheduleID){
            this.scheduleID = scheduleID;
            return this;
        }
        public Builder trainID(int trainID){
            this.trainID = trainID;
            return this;
        }
        public TrainSchedule build(){
            return new TrainSchedule(this);
        }
    }
}
