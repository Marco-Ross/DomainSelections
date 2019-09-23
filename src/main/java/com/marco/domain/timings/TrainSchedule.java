package com.marco.domain.timings;

public class TrainSchedule {
    private String scheduleID;
    private String trainNumber;

    private TrainSchedule(){}

    private TrainSchedule(Builder builder){
        this.scheduleID = builder.scheduleID;
        this.trainNumber = builder.trainNumber;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public static class Builder{
        private String scheduleID;
        private String trainNumber;

        public Builder scheduleID(String scheduleID){
            this.scheduleID = scheduleID;
            return this;
        }
        public Builder trainNumber(String trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }
        public TrainSchedule build(){
            return new TrainSchedule(this);
        }
    }
}
