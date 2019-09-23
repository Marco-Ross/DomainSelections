package com.marco.domain.timings;

import java.util.Date;

public class Schedule {
    private String scheduleID;
    private String arrival;
    private String departure;

    private Schedule() {
    }

    private Schedule(Builder builder){
        this.departure = builder.departure;
        this.arrival = builder.arrival;
        this.scheduleID = builder.scheduleID;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public static class Builder{
        private String scheduleID;
        private String arrival;
        private String departure;

        public Builder scheduleID(String scheduleID){
            this.scheduleID = scheduleID;
            return this;
        }

        public Builder departure(String departure){
            this.departure = departure;
            return this;
        }

        public Builder arrival(String arrival){
            this.arrival = arrival;
            return this;
        }

        public Builder copy(Schedule schedule){
            this.scheduleID = schedule.scheduleID;
            this.arrival = schedule.arrival;
            this.departure = schedule.departure;

            return this;
        }

        public Schedule build(){return new Schedule(this);}
    }
}
