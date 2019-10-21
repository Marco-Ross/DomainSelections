package com.marco.domain.timings.clientobject;

public class NewSchedule {
    private int trainNumber;
    private int capacity;
    private String departureDate;
    private String departure;
    private String arrival;
    private String departureLocation;
    private String arrivalLocation;

    private NewSchedule() {
    }

    private NewSchedule(NewSchedule.Builder builder){
        this.trainNumber = builder.trainNumber;
        this.capacity = builder.capacity;
        this.departure = builder.departure;
        this.arrival = builder.arrival;
        this.departureDate = builder.departureDate;
        this.departureLocation = builder.departureLocation;
        this.arrivalLocation = builder.arrivalLocation;
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

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public static class Builder{
        private int trainNumber;
        private int capacity;
        private String departureDate;
        private String departure;
        private String arrival;
        private String departureLocation;
        private String arrivalLocation;

        public Builder trainNumber(int trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public NewSchedule.Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder departureDate(String departureDate){
            this.departureDate = departureDate;
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
        public NewSchedule.Builder departureLocation(String departureLocation){
            this.departureLocation = departureLocation;
            return this;
        }
        public NewSchedule.Builder arrivalLocation(String arrivalLocation){
            this.arrivalLocation = arrivalLocation;
            return this;
        }

        public NewSchedule.Builder copy(NewSchedule schedule){
            this.trainNumber = schedule.trainNumber;
            this.capacity = schedule.capacity;
            this.departureDate = schedule.departureDate;
            this.arrival = schedule.arrival;
            this.departure = schedule.departure;
            this.departureLocation = schedule.departureLocation;
            this.arrivalLocation = schedule.arrivalLocation;

            return this;
        }

        public NewSchedule build(){return new NewSchedule(this);}
    }
}
