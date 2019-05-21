package com.marco.domain.transit;

public class Train {
    private int trainNumber;
    private int capacity;
    private String trainName;


    private Train(){}

    private Train(Builder builder){
        this.trainNumber = builder.trainNumber;
        this.capacity = builder.capacity;
        this.trainName = builder.trainName;
    }

    public int getTrainNumber(){return trainNumber;}

    public int getCapacity(){return capacity;}

    public String getTrainName(){
        return trainName;
    }

    public static class Builder{
        private int trainNumber;
        private int capacity;
        private String trainName;

        public Builder trainNumber(int trainNumber){
            this.trainNumber = trainNumber;
            return this;
        }

        public Builder capacity(int capacity){
            this.capacity = capacity;
            return this;
        }

        public Builder trainName(String trainName){
            this.trainName = trainName;
            return this;
        }

        public Builder copy(Train train){
            this.trainNumber = train.trainNumber;
            this.capacity = train.capacity;
            this.trainName = train.trainName;

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

