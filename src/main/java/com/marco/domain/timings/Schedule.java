package com.marco.domain.timings;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int scheduleID;
    private String departureDate;
    private String arrival;
    private String departure;

    private Schedule() {
    }

    private Schedule(Builder builder){
        this.departure = builder.departure;
        this.departureDate = builder.departureDate;
        this.arrival = builder.arrival;
        this.scheduleID = builder.scheduleID;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public static class Builder{
        private int scheduleID;
        private String departureDate;
        private String arrival;
        private String departure;

        public Builder scheduleID(int scheduleID){
            this.scheduleID = scheduleID;
            return this;
        }

        public Builder departureDate(String departureDate){
            this.departureDate = departureDate;
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
            this.departureDate = schedule.departureDate;
            this.arrival = schedule.arrival;
            this.departure = schedule.departure;

            return this;
        }

        public Schedule build(){return new Schedule(this);}
    }
}
