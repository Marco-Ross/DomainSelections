package com.marco.domain.timings.clientobject;

public class NewSchedule {
    private int trainNumber;
    private int capacity;
    private String departure;
    private String arrival;

    private NewSchedule() {
    }

    private NewSchedule(NewSchedule.Builder builder){
        this.trainNumber = builder.trainNumber;
        this.capacity = builder.capacity;
        this.departure = builder.departure;
        this.arrival = builder.arrival;
    }

    public int getTrainNumber(){return trainNumber;}

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public int getCapacity() {
        return capacity;
    }

    public static class Builder{
        private int trainNumber;
        private int capacity;
        private String arrival;
        private String departure;

        public Builder trainNumber(int trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public NewSchedule.Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public NewSchedule.Builder departure(String departure){
            this.departure = departure;
            return this;
        }

        public NewSchedule.Builder arrival(String arrival){
            this.arrival = arrival;
            return this;
        }

        public NewSchedule.Builder copy(NewSchedule schedule){
            this.trainNumber = schedule.trainNumber;
            this.capacity = schedule.capacity;
            this.arrival = schedule.arrival;
            this.departure = schedule.departure;

            return this;
        }

        public NewSchedule build(){return new NewSchedule(this);}
    }
}
