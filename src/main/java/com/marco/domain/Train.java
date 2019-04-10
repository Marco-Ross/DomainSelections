package com.marco.domain;

public class Train {
    private int trainNumber;
    private int capacity;

    private Train(){}

    private Train(Builder builder){
        this.trainNumber = builder.trainNumber;
        this.capacity = builder.capacity;
    }

    public int getTrainNumber(){return trainNumber;}

    public int getCapacity(){return capacity;}

    public static class Builder{
        private int trainNumber;
        private int capacity;

        public Builder trainNumber(int trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
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

