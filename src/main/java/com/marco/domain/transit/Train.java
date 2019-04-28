package com.marco.domain.transit;

public class Train {
    private int trainNumber;
    private int capacity;
    private String trainLocation;

    private Train(){}

    private Train(Builder builder){
        this.trainNumber = builder.trainNumber;
        this.capacity = builder.capacity;
        this.trainLocation = builder.trainLocation;
    }

    public int getTrainNumber(){return trainNumber;}

    public int getCapacity(){return capacity;}

    public String getTrainLocation(){
        return trainLocation;
    }

    public static class Builder{
        private int trainNumber;
        private int capacity;
        private String trainLocation;

        public Builder trainNumber(int trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder trainLocation(String trainLocation){
            this.trainLocation = trainLocation;
            return this;
        }

        public Train build(){return new Train(this);}
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", capacity=" + capacity +
                '}';
    }
}

